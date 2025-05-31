package org.fcuevas.carro.servicio;

import org.fcuevas.carro.modelo.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoServicio {

    public List<Producto> listar();
    public Optional<Producto> buscarPorId(Long id);
}
