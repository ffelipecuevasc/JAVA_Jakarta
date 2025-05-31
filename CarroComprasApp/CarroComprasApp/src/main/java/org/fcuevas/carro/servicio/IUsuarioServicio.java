package org.fcuevas.carro.servicio;

import org.fcuevas.carro.modelo.Usuario;

import java.util.Optional;

public interface IUsuarioServicio {

    Optional<Usuario> iniciarSesion(String username, String password);
}
