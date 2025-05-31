package org.fcuevas.session.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.fcuevas.session.servicio.ILoginServicio;
import org.fcuevas.session.servicio.LoginSessionServicio;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/logout.html")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ILoginServicio loginServicio = new LoginSessionServicio();
        Optional<String> sessionOptional = loginServicio.getUsername(req);
        if(sessionOptional.isPresent()){
            HttpSession session = req.getSession();
            session.removeAttribute("username");
        }
        resp.sendRedirect("/SessionApp/login.html");
    }
}
