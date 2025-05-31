package org.fcuevas.carro.servicio;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface ILoginServicio {

    public Optional<String> getUsername(HttpServletRequest request);
}
