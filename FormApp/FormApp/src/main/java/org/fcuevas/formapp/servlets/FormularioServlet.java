package org.fcuevas.formapp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/registro")
public class FormularioServlet extends HttpServlet {

    /*¿Por qué es vital añadir la dependencia jakarta.jakartaee-api?
    * Cuando haces aplicaciones web con Servlets, JSP, filtros, listeners, etc., estás usando
    * las especificaciones de Jakarta EE (antes Java EE). Esta API incluye interfaces como:
    *
    * - HttpServlet, ServletRequest, ServletResponse
    * - RequestDispatcher, HttpSession
    * - @WebServlet, @WebFilter
    * - JSP y muchas otras
    *
    * ¿Cómo maneja Tomcat esta solicitud?
    * 1) Tomcat escucha en un puerto (por defecto el 8080).
    * 2) Cuando recibe una solicitud a /servlet, consulta el web.xml o las anotaciones
    * (@WebServlet) para decidir qué clase Java manejará esa ruta.
    * 3) Instancia (o reutiliza) el Servlet correspondiente.
    * 4) Llama al método doPost() o doGet() dependiendo del tipo de solicitud.
    * 5) Pasa los datos dentro de un objeto HttpServletRequest.
    *
    * ¿Cómo paso esa información a una nueva vista (resultado.jsp)?
    * Dentro del Servlet, puedes reenviar (forward) la solicitud, junto con los datos del
    * formulario, usando el RequestDispatcher.
    *
    *       request.setAttribute("nombreUsuario", nombre);
    *       request.getRequestDispatcher("resultado.jsp").forward(request, response);
    * */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        String email = request.getParameter("email");
        String pais = request.getParameter("pais");
        String[] lenguajes = request.getParameterValues("lenguajes");
        String[] roles = request.getParameterValues("rol");
        String idioma = request.getParameter("idioma");
        Boolean habilitar = request.getParameter("habilitar").equals("on");
        String secreto = request.getParameter("secreto");

        response.setContentType("text/html");

        Map<String, String> errores = new HashMap<>();

        if (usuario == null || usuario.isBlank()) {
            errores.put("Usuario","El usuario es requerido.");
        }

        if (clave == null || clave.isBlank()) {
            errores.put("Clave","La clave es requerida.");
        }

        if (email == null || !(email.contains("@"))) {
            errores.put("Email","El email es requerido y debe tener formato de email.");
        }

        if (pais == null || pais.isBlank()) {
            errores.put("Pais","El pais es requerido.");
        }

        if (lenguajes == null || lenguajes.length == 0) {
            errores.put("Lenguaje","Al menos 1 lenguaje es requerido.");
        }

        if (roles == null || roles.length == 0) {
            errores.put("Rol","Al menos 1 rol es requerido.");
        }

        if (idioma == null) {
            errores.put("Idioma","El idioma es requerido.");
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Resultado Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Resultado del Formulario - Servlet</h1>");
            out.println("<ul>");
            if (errores.isEmpty()) {
                out.println("<li>Usuario = " + usuario + "</li>");
                out.println("<li>Clave = " + clave + "</li>");
                out.println("<li>Email = " + email + "</li>");
                out.println("<li>País = " + pais + "</li>");
                out.println("<li>Lenguajes :<ul>");
                for (String lenguaje : lenguajes) {
                    out.println("<li>" + lenguaje + "</li>");
                }
                out.println("</ul></li>");
                out.println("<li>Roles :<ul>");
                for (String rol : roles) {
                    out.println("<li>" + rol + "</li>");
                }
                out.println("</ul></li>");
                out.println("<li>Idioma = " + idioma + "</li>");
                out.println("<li>Habilitar = " + habilitar + "</li>");
                out.println("<li>Secreto = " + secreto + "</li>");
                out.println("</ul>");
                out.println("</body>");
                out.println("</html>");
            }else{
                /* Acá

                errores.forEach(e -> {
                    out.println("<li>Error = " + e + "</li>");
                });
                out.println("<p><a href=\"/FormApp/index.jsp\">Volver al inicio</a></p>");*/
                request.setAttribute("errores",errores);
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            }
        }
    }
}
