package org.fcuevas.cookies.servicio;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Optional;

public class LoginServicio implements ILoginServicio{

    /*Cookies
    *
    * 📍 Dónde vive	    -> En el navegador del cliente
    * 📦 Qué guarda	    -> Información simple (clave-valor), como username=juan
    * 🔐 Seguridad	    -> Menos seguro (puede ser visible y manipulable por el cliente)
    * 🕐 Duración	    -> Controlada por ti (setMaxAge)
    * 📡 Transmisión	-> Se envía en cada solicitud al servidor
    * 🧰 Uso común	    -> Recordar usuario, preferencias, autenticación ligera
    *
    * Se recomienda su uso en los siguientes casos:
    *
    * - Para recordar datos simples entre sesiones (idioma, usuario recordado).
    * - Cuando necesitas persistencia del lado del cliente.
    * - Usa Cookies cuando quieras guardar preferencias del usuario o cosas simples que
    *   el navegador puede recordar.
    * */

    @Override
    public Optional<String> getUsername(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies() != null ? request.getCookies() : new Cookie[0];
        return Arrays.stream(cookies).
                filter(c -> c.getName().equals("username")).
                map(Cookie::getValue).
                findAny();
    }
}
