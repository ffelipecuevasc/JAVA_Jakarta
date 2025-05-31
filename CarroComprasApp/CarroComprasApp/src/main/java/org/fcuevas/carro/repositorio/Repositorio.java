package org.fcuevas.carro.repositorio;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.fcuevas.carro.modelo.Producto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Repositorio implements IRepositorio<Producto>{

    @Inject
    @Named("con")
    private Connection c;

    /* Anteriormente, el constructor recibía el objeto Connection para inicializar la variable. Estaba
    *  de la siguiente forma:
    *
    *        public Repositorio(Connection c) {
    *            this.c = c;
    *        }
    *
    * Con inyección de dependencias CDI se puede inyectar de 3 maneras:
    * 1) Realizar inyección en el atributo.
    * 2) Realizar inyección en el constructor.
    * 3) Realizar inyección en el método set().
    *
    * En el caso del constructor, la inyección sería así:
    *
    *       @Inject
    *       public Repositorio(@Named("con") Connection c) {
    *            this.c = c;
    *       }*/

    @Override
    public List<Producto> listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos;";
        try(Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql)){
            while(rs.next()){
                Producto p = obtenerProducto(rs);
                productos.add(p);
            }
        }
        return productos;
    }

    @Override
    public Producto porId(Long id) throws SQLException {
        Producto p;
        String sql = "SELECT * FROM productos WHERE id_pro = " + id + ";";
        try(Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql)){
            if(rs.next()) p = obtenerProducto(rs);
            else p = null;
        }
        return p;
    }

    @Override
    public void guardar(Producto producto) throws SQLException {
        String sql = "INSERT INTO productos VALUES(NULL," +
                "'" + producto.getNombre() + "'," +
                "'" + producto.getTipo() + "'," +
                producto.getPrecio() + ");";
        Statement st = c.createStatement();
        st.execute(sql);
        st.close();
    }

    @Override
    public void actualizar(Producto producto) throws SQLException {
        String sql = "UPDATE productos SET nom_pro = '" + producto.getNombre() + "'," +
                "tip_pro = '" + producto.getTipo() + "'," +
                "pre_pro = " + producto.getPrecio() + " WHERE id_pro = " + producto.getId() + ";";
        Statement st = c.createStatement();
        st.execute(sql);
        st.close();
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        String sql = "DELETE FROM productos WHERE id_pro = " + id + ";";
        Statement st = c.createStatement();
        st.execute(sql);
        st.close();
    }

    private static Producto obtenerProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto(rs.getLong("id_pro"),
                rs.getString("nom_pro"),
                rs.getString("tip_pro"),
                rs.getInt("pre_pro"));
        return p;
    }
}
