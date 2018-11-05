package com.b2wdigital.desafio.model.exception;

import org.springframework.http.HttpStatus;

public class PlanetaException extends Exception {

    private HttpStatus httpStatus;

    public PlanetaException() {
        super();
    }

    public PlanetaException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
    
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
