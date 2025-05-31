package org.fcuevas.carro.controladores;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.fcuevas.carro.servicio.IProductoBDServicio;
import org.fcuevas.carro.servicio.ProductoBDServicio;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/form/producto/eliminar")
public class ProductoEliminarServlet extends HttpServlet {

    @Inject
    private ProductoBDServicio servicio;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Connection c = (Connection) req.getAttribute("c");
        //IProductoBDServicio servicio = new ProductoBDServicio(c);
        servicio.eliminar(Long.valueOf(req.getParameter("id")));
        resp.sendRedirect("/CarroComprasApp/productos");
    }

}
