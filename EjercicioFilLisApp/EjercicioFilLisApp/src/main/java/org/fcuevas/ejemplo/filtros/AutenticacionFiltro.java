package org.fcuevas.ejemplo.filtros;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/zonaprivada.jsp")
public class AutenticacionFiltro implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession(false);

        Boolean logueado = session != null && session.getAttribute("username") != null;
        if(logueado) filterChain.doFilter(servletRequest, servletResponse);
        else request.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
    }
}
