package org.fcuevas.carro.filtros;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.fcuevas.carro.excepciones.ServicioException;
import org.fcuevas.carro.utilidades.ConexionBaseDatos;
import org.fcuevas.carro.utilidades.ConexionPoolBaseDatos;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/*")
public class ConexionBdFiltro implements Filter {

    @Inject
    @Named("con")
    private Connection con;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //El try originalmente estaba = try(Connection c = ConexionPoolBaseDatos.getConexion())
        //Ahora solo hace referencia al objeto inyectado como atributo de esta clase filter
        try(Connection c = this.con){
            if(c.getAutoCommit()){
                c.setAutoCommit(false);
            }
            try{
                //servletRequest.setAttribute("c",c);
                filterChain.doFilter(servletRequest,servletResponse);
                c.commit();
            }catch(SQLException | ServicioException e){
                c.rollback();
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,e.getMessage());
                e.printStackTrace();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
