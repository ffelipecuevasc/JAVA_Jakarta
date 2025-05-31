package org.fcuevas.carro.filtros;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.fcuevas.carro.servicio.ILoginServicio;
import org.fcuevas.carro.servicio.LoginSessionServicio;

import java.io.IOException;
import java.util.Optional;

@WebFilter("/carro/*")
public class LoginFiltro implements Filter {

    /*
    * ¿Qué es un Filter?
    * Es una clase especial que implementa la interfaz jakarta.servlet.Filter. Se usa para ejecutar lógica
    * antes y/o después del procesamiento de la solicitud, sin necesidad de tocar el código del
    * servlet directamente.
    *
    * ¿Para qué sirve un Filter?
    * 🔒 Autenticación / autorización	        -> Bloquear acceso si el usuario no está logueado
    * 📝 Registro de actividad (logging)	    -> Registrar solicitudes que entran al sistema
    * 🔄 Compresión o modificación de datos	    -> Modificar la respuesta (por ejemplo, comprimirla en GZIP)
    * 🧼 Limpieza de datos o encoding	        -> Forzar codificación UTF-8 en solicitudes
    * 🚧 Mantenimiento o redirección	        -> Mostrar una página de mantenimiento temporalmente
    *
    * ¿Cómo funciona en el flujo?
    * Cliente ─▶ Filter ─▶ Servlet o JSP ─▶ Filter (de nuevo) ─▶ Cliente
    *
    * Un Filter puede:
    * - Dejar pasar la solicitud al siguiente eslabón (con chain.doFilter(...))
    * - Modificar la solicitud o la respuesta
    * - Detener completamente la ejecución (por ejemplo, redirigir o responder directamente)
    * */

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ILoginServicio servicio = new LoginSessionServicio();
        Optional<String> username = servicio.getUsername((HttpServletRequest) servletRequest);
        if(username.isPresent()){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                    "No está autorizado para ingresar a esta parte del sitio web.");
        }
    }
}
