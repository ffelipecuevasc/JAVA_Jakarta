package org.fcuevas.carro.controladores;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.fcuevas.carro.modelo.Carro;
import org.fcuevas.carro.modelo.ItemCarro;
import org.fcuevas.carro.modelo.Producto;
import org.fcuevas.carro.servicio.IProductoServicio;
import org.fcuevas.carro.servicio.ProductoBDServicio;
import org.fcuevas.carro.servicio.ProductoServicio;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/carro/agregar")
public class AgregarCarroServlet extends HttpServlet {

    /*Los clientes no compartirán el atributo carro inyectado, aunque el Servlet es una única
    * instancia. Gracias a que el bean Carro está anotado con @SessionScoped, CDI se encarga
    * de inyectar una instancia distinta del objeto carro para cada sesión de usuario.*/
    @Inject
    private Carro carro;

    @Inject
    private ProductoBDServicio service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        //Connection c = (Connection) req.getAttribute("c");
        //ProductoBDServicio service = new ProductoBDServicio(c);
        Optional<Producto> optionalProducto = service.buscarPorId(id);
        if (optionalProducto.isPresent()) {
            ItemCarro item = new ItemCarro(1, optionalProducto.get());
            //HttpSession session = req.getSession();
            //Carro carro = (Carro) session.getAttribute("carro");
            carro.addItem(item);
        }
        resp.sendRedirect("/CarroComprasApp/carro/ver");
    }
}
