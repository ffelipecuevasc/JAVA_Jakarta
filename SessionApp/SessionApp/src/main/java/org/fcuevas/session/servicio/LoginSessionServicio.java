package org.fcuevas.session.servicio;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public class LoginSessionServicio implements ILoginServicio{

    /*Sesiones HTTP (HttpSession)
    *
    * 📍 Dónde vive	    -> En el servidor (Tomcat, etc.)
    * 📦 Qué guarda	    -> Objetos Java completos (no solo texto)
    * 🔐 Seguridad	    -> Más seguro (el cliente no accede al contenido, solo al ID)
    * 🕐 Duración	    -> Mientras dure la sesión (o se invalide)
    * 📡 Transmisión	-> El cliente envía solo el JSESSIONID (cookie automática de sesión)
    * 🧰 Uso común	    -> Guardar objetos de usuario, carrito de compras, sesión autenticada
    *
    * Se recomienda utilizarlas en los siguientes escenarios:
    *
    * - Para manejar lógica de sesión como login, permisos, carritos.
    * - Cuando necesitas seguridad y manejar objetos Java complejos.
    * - Usa HttpSession para la lógica sensible o interna del servidor.
    * */

    @Override
    public Optional<String> getUsername(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if(username != null) return Optional.of(username);
        else return Optional.empty();
    }
}
