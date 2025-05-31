package org.fcuevas.carro.controladores;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.fcuevas.carro.modelo.Usuario;
import org.fcuevas.carro.servicio.ILoginServicio;
import org.fcuevas.carro.servicio.LoginSessionServicio;
import org.fcuevas.carro.servicio.UsuarioServicio;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Inject
    private LoginSessionServicio loginServicio;

    @Inject
    private UsuarioServicio usuarioServicio;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //UsuarioServicio usuarioServicio = new UsuarioServicio((Connection) req.getAttribute("c"));
        Optional<Usuario> optionalUsuario = usuarioServicio.iniciarSesion(username,password);
        if (optionalUsuario.isPresent()) {
            HttpSession session = req.getSession();
            session.setAttribute("username",username);
            resp.setContentType("text/html;charset=UTF-8");
            resp.sendRedirect("/CarroComprasApp/login");
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no esta autorizado para ingresar a esta página!");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ILoginServicio loginServicio = new LoginSessionServicio();
        Optional<String> sessionOptional = loginServicio.getUsername(req);
        req.setAttribute("titulo","Sesion de Usuario");
        if(sessionOptional.isPresent()){
            req.setAttribute("username",sessionOptional);
            req.getRequestDispatcher("/bienvenida.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
