package org.fcuevas.carro.repositorio;

import org.fcuevas.carro.modelo.Usuario;

import java.sql.SQLException;

public interface IUsuarioRepositorio extends IRepositorio<Usuario> {

    Usuario porUsuario(String nomUsuario) throws SQLException;
}
