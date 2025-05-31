package org.fcuevas.carro.controladores;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.fcuevas.carro.servicio.ILoginServicio;
import org.fcuevas.carro.servicio.LoginSessionServicio;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Inject
    private LoginSessionServicio loginServicio;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ILoginServicio loginServicio = new LoginSessionServicio();
        Optional<String> sessionOptional = loginServicio.getUsername(req);
        if(sessionOptional.isPresent()){
            HttpSession session = req.getSession();
            session.removeAttribute("username");
        }
        resp.sendRedirect("/CarroComprasApp/login");
    }
}
