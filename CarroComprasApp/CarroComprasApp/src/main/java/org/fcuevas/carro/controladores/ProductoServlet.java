package org.fcuevas.carro.controladores;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.fcuevas.carro.modelo.Producto;
import org.fcuevas.carro.servicio.ILoginServicio;
import org.fcuevas.carro.servicio.LoginSessionServicio;
import org.fcuevas.carro.servicio.ProductoBDServicio;
import org.fcuevas.carro.servicio.ProductoServicio;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productos.html", "/productos"})
public class ProductoServlet extends HttpServlet {

    @Inject
    private ProductoBDServicio service;

    @Inject
    private LoginSessionServicio loginServicio;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Connection c = (Connection) req.getAttribute("c");
        //ProductoBDServicio service = new ProductoBDServicio(c);
        List<Producto> productos = service.listar();

        //ILoginServicio loginServicio = new LoginSessionServicio();
        Optional<String> sessionOptional = loginServicio.getUsername(req);

        req.setAttribute("productos",productos);
        req.setAttribute("username",sessionOptional);
        req.setAttribute("titulo","Listado de Productos");
        req.getRequestDispatcher("/listar.jsp").forward(req,resp);
    }
}