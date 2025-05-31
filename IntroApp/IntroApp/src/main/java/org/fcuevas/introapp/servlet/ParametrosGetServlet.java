package org.fcuevas.introapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/parametrogetservlet")
public class ParametrosGetServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String saludo = request.getParameter("saludo");
        String nombre = request.getParameter("nombre");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hola desde el Servlet</h1>");
        if(saludo != null && nombre != null) out.println("<h3>Saludo enviado es: "+ saludo + " " + nombre +"</h3>");
        else if(saludo != null) out.println("<h3>Saludo enviado es: "+ saludo + "</h3>");
        else out.println("<h3>Parámetros no enviados</h3>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
