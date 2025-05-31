package org.fcuevas.session.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.fcuevas.session.servicio.ILoginServicio;
import org.fcuevas.session.servicio.LoginSessionServicio;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet({"/login","/login.html"})
public class LoginServlet extends HttpServlet {

    final static String USERNAME = "admin";
    final static String PASSWORD = "12345";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("username",username);
            resp.setContentType("text/html;charset=UTF-8");
            resp.sendRedirect("/SessionApp/login.html");
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no esta autorizado para ingresar a esta página!");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ILoginServicio loginServicio = new LoginSessionServicio();
        Optional<String> sessionOptional = loginServicio.getUsername(req);

        if(sessionOptional.isPresent()){
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<title>Sesión</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>¡Inicio de Sesión exitoso!</h1>");
                out.println("<h4>Hola '" + sessionOptional.get() + "' ¡Iniciaste sesión!</h4>");
                out.println("<p><a href='/SessionApp/index.html'>Volver</a></p>");
                out.println("<p><a href='/SessionApp/logout.html'>Salir</a></p>");
                out.println("</body>");
                out.println("</html>");
            }
        }else{
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
