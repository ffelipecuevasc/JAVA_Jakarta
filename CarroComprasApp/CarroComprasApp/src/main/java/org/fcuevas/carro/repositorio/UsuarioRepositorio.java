package org.fcuevas.carro.repositorio;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.fcuevas.carro.modelo.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@ApplicationScoped
public class UsuarioRepositorio implements IUsuarioRepositorio{

    @Inject
    @Named("con")
    private Connection c;

    @Override
    public List<Usuario> listar() throws SQLException {
        return null;
    }

    @Override
    public Usuario porId(Long id) throws SQLException {
        return null;
    }

    @Override
    public void guardar(Usuario usuario) throws SQLException {

    }

    @Override
    public void eliminar(Long id) throws SQLException {

    }

    @Override
    public void actualizar(Usuario usuario) throws SQLException {

    }

    @Override
    public Usuario porUsuario(String nomUsuario) throws SQLException {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE usu_usu = '" + nomUsuario + "';";
        try(Statement st = this.c.createStatement();
            ResultSet rs = st.executeQuery(sql)){
            if(rs.next()){
                usuario = obtenerUsuario(rs);
            }
        }
        return usuario;
    }

    private static Usuario obtenerUsuario(ResultSet rs) throws SQLException {
        Usuario usuario;
        usuario = new Usuario();
        usuario.setId(rs.getLong("id_usu"));
        usuario.setUsuario(rs.getString("usu_usu"));
        usuario.setClave(rs.getString("cla_usu"));
        return usuario;
    }
}
