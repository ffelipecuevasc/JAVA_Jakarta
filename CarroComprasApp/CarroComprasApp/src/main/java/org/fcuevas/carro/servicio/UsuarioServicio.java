package org.fcuevas.carro.servicio;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.fcuevas.carro.excepciones.ServicioException;
import org.fcuevas.carro.modelo.Usuario;
import org.fcuevas.carro.repositorio.UsuarioRepositorio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@ApplicationScoped
public class UsuarioServicio implements IUsuarioServicio{

    @Inject
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public Optional<Usuario> iniciarSesion(String username, String password) {
        try{
            return Optional.ofNullable(this.usuarioRepositorio.porUsuario(username))
                    .filter(u -> u.getClave().equals(password));
        }catch(SQLException e){
            throw new ServicioException(e.getMessage(),e.getCause());
        }
    }
}
