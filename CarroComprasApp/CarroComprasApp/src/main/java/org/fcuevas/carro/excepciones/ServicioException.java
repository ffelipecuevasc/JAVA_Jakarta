package org.fcuevas.carro.excepciones;

public class ServicioException extends RuntimeException{
    public ServicioException(String message) {
        super(message);
    }

    public ServicioException(String message, Throwable cause) {
        super(message, cause);
    }
}
