package org.fcuevas.cabeceras;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/headers")
public class CabecerasHTTPServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        String métodoHttp = request.getMethod(),
               requestUri = request.getRequestURI(),
               requestUrl = request.getRequestURL().toString(),
               contextPath = request.getContextPath(),
               servletPath = request.getServletPath(),
               ipHost = request.getLocalAddr(),
               ipCliente = request.getRemoteAddr(),
               puerto = String.valueOf(request.getLocalPort()),
               esquema = request.getScheme(),
               host = request.getHeader("host"),
               url = esquema + "://" + host + contextPath + servletPath;

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Headers HTTP</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Headers HTTP Servlet</h1>");
            out.println("<ul>");
            out.println("<li>HTTP Method = "+métodoHttp+"</li>");
            out.println("<li>URI Request = "+requestUri+"</li>");
            out.println("<li>URL Request = "+requestUrl+"</li>");
            out.println("<li>Context Path = "+contextPath+"</li>");
            out.println("<li>Servlet Path = "+servletPath+"</li>");
            out.println("<li>Port Host = "+puerto+"</li>");
            out.println("<li>IP Host = "+ipHost+"</li>");
            out.println("<li>Scheme = "+esquema+"</li>");
            out.println("<li>Host = "+host+"</li>");
            out.println("<li>Complete URL = "+url+"</li>");
            out.println("<li>IP Client = "+ipCliente+"</li>");
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
