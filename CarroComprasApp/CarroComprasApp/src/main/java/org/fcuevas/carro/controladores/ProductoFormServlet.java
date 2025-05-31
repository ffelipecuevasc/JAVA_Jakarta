package org.fcuevas.carro.controladores;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.fcuevas.carro.modelo.Producto;
import org.fcuevas.carro.servicio.IProductoBDServicio;
import org.fcuevas.carro.servicio.ProductoBDServicio;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/form/producto")
public class ProductoFormServlet extends HttpServlet {

    @Inject
    private ProductoBDServicio servicio;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Connection c = (Connection) req.getAttribute("c");
        //IProductoBDServicio servicio = new ProductoBDServicio(c);
        Long id;
        try{
            id = Long.valueOf(req.getParameter("id"));
        }catch(NumberFormatException e){
            id = 0L;
        }
        Producto p = new Producto();
        if(id > 0){
            Optional<Producto> productoOptional = servicio.buscarPorId(id);
            if(productoOptional.isPresent()) p = productoOptional.get();
        }
        req.setAttribute("producto",p);
        req.setAttribute("titulo","Formulario de Producto");
        req.getRequestDispatcher("/producto.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Connection c = (Connection) req.getAttribute("c");
        //IProductoBDServicio servicio = new ProductoBDServicio(c);

        Map<String, String> errores = new HashMap<>();
        if(req.getParameter("nombre") == null || req.getParameter("nombre").isBlank())
            errores.put("nombre","El nombre es obligatorio");
        if(req.getParameter("tipo") == null || req.getParameter("tipo").isBlank())
            errores.put("tipo","El tipo es obligatorio");
        if(req.getParameter("precio") == null || req.getParameter("precio").isBlank())
            errores.put("precio","El precio es obligatorio");

        if(errores.isEmpty()){
            Producto producto = new Producto();
            if(req.getParameter("id").equals("null") || req.getParameter("id").isBlank()) producto.setId(null);
            else producto.setId(Long.valueOf(req.getParameter("id")));
            producto.setNombre(req.getParameter("nombre"));
            producto.setTipo(req.getParameter("tipo"));
            producto.setPrecio(Integer.parseInt(req.getParameter("precio")));
            if(req.getParameter("id").equals("null") || req.getParameter("id").isBlank()) servicio.guardar(producto);
            else servicio.actualizar(producto);
            resp.sendRedirect("/CarroComprasApp/productos");
        }else{
            req.setAttribute("errores",errores);
            req.setAttribute("titulo","Formulario de Producto");
            req.getRequestDispatcher("/producto.jsp").forward(req, resp);
        }
    }
}