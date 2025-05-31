package org.fcuevas.session.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.fcuevas.session.modelo.Producto;
import org.fcuevas.session.servicio.ILoginServicio;
import org.fcuevas.session.servicio.LoginSessionServicio;
import org.fcuevas.session.servicio.ProductoServicio;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productos.html", "/productos"})
public class ProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        ProductoServicio service = new ProductoServicio();
        List<Producto> productos = service.listar();

        ILoginServicio loginServicio = new LoginSessionServicio();
        Optional<String> sessionOptional = loginServicio.getUsername(req);

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Listado de Productos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Listado de Productos!</h1>");
            if(sessionOptional.isPresent()) out.println("<div>Hola '"+sessionOptional.get()+"'</div>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>id</th>");
            out.println("<th>nombre</th>");
            out.println("<th>tipo</th>");
            if(sessionOptional.isPresent()) out.println("<th>precio</th>");
            out.println("</tr>");
            productos.forEach(p -> {
                out.println("<tr>");
                out.println("<td>" + p.getId() + "</td>");
                out.println("<td>" + p.getNombre() + "</td>");
                out.println("<td>" + p.getTipo() + "</td>");
                if(sessionOptional.isPresent()) out.println("<td>" + p.getPrecio() + "</td>");
                out.println("</tr>");
            });
            out.println("</table>");
            out.println("    </body>");
            out.println("</html>");

        }
    }
}