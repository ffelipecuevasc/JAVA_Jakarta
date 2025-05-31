package org.fcuevas.cookies.servicio;

import org.fcuevas.cookies.modelo.Producto;

import java.util.Arrays;
import java.util.List;

public class ProductoServicio implements IProductoServicio{
    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1L, "notebook", "computacion", 175000),
                new Producto(2L, "mesa escritorio", "oficina", 100000),
                new Producto(3L, "teclado mecanico", "computacion", 40000));
    }
}
