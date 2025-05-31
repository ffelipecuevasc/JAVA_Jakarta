package org.fcuevas.cookies.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.fcuevas.cookies.servicio.ILoginServicio;
import org.fcuevas.cookies.servicio.LoginServicio;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/logout.html")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ILoginServicio loginServicio = new LoginServicio();
        Optional<String> cookieOptional = loginServicio.getUsername(req);
        if(cookieOptional.isPresent()){
            Cookie cookie;
            cookie = new Cookie("username", cookieOptional.get());
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        }
        resp.sendRedirect("/CookiesApp/login.html");
    }
}
