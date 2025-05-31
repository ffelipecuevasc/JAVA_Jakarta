package org.fcuevas.carro.servicio;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.fcuevas.carro.excepciones.ServicioException;
import org.fcuevas.carro.modelo.Producto;
import org.fcuevas.carro.repositorio.Repositorio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductoBDServicio implements IProductoBDServicio{

    @Inject
    private Repositorio repositorio;

    @Override
    public List<Producto> listar() {
        try {
            return this.repositorio.listar();
        } catch (SQLException e) {
            throw new ServicioException(e.getMessage(),e.getCause());
        }
    }

    @Override
    public Optional<Producto> buscarPorId(Long id) {
        try {
            return Optional.ofNullable(this.repositorio.porId(id));
        } catch (SQLException e) {
            throw new ServicioException(e.getMessage(),e.getCause());
        }
    }

    @Override
    public void guardar(Producto producto) {
        try {
            this.repositorio.guardar(producto);
        } catch (SQLException e) {
            throw new ServicioException(e.getMessage(),e.getCause());
        }
    }

    @Override
    public void actualizar(Producto producto) {
        try {
            this.repositorio.actualizar(producto);
        } catch (SQLException e) {
            throw new ServicioException(e.getMessage(),e.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            this.repositorio.eliminar(id);
        } catch (SQLException e) {
            throw new ServicioException(e.getMessage(),e.getCause());
        }
    }
}
