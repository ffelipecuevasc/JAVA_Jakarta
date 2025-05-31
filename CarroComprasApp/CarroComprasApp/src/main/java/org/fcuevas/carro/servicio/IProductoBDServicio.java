package org.fcuevas.carro.servicio;

import org.fcuevas.carro.modelo.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoBDServicio {
    public List<Producto> listar();
    public Optional<Producto> buscarPorId(Long id);

    public void guardar(Producto producto);

    public void actualizar(Producto producto);

    public void eliminar(Long id);
}
