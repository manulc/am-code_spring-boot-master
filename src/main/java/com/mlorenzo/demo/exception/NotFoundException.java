package com.mlorenzo.demo.exception;

// Se comenta porque ahora manejamos esta excepción de forma global para todos los controladores de la
// aplicación en el manejador de excepciones "ApiExceptionHandlerController".
//@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
