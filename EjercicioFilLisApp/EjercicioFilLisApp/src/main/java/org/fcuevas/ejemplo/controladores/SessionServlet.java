package org.fcuevas.ejemplo.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class SessionServlet extends HttpServlet {

    private static String USERNAME = "admin";
    private static String PASSWORD = "12345";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(username.equals(USERNAME) && password.equals(PASSWORD)){
            HttpSession session = req.getSession();
            session.setAttribute("username",username);
            resp.sendRedirect(req.getContextPath() + "/zonaprivada.jsp");
        }else{
            req.setAttribute("error","Credenciales incorrectas.");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
