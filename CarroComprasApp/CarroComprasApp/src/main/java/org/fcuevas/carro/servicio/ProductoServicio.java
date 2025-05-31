package org.fcuevas.carro.servicio;

import jakarta.enterprise.inject.Alternative;
import org.fcuevas.carro.modelo.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Alternative
public class ProductoServicio implements IProductoServicio{

    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1L, "notebook", "computacion", 175000),
                new Producto(2L, "mesa escritorio", "oficina", 100000),
                new Producto(3L, "teclado mecanico", "computacion", 40000));
    }

    @Override
    public Optional<Producto> buscarPorId(Long id) {
        return this.listar().stream().filter(i -> i.getId().equals(id)).findFirst();
    }
}
