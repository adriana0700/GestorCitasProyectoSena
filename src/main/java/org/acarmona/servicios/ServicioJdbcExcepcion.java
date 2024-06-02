package org.acarmona.servicios;

public class ServicioJdbcExcepcion extends RuntimeException{

    public ServicioJdbcExcepcion(String message) {
        super(message);
    }

    public ServicioJdbcExcepcion(String message, Throwable cause) {
        super(message, cause);
    }
}
