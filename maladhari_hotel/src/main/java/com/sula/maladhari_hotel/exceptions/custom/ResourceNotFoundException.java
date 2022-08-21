package com.sula.maladhari_hotel.exceptions.custom;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends Exception {

    private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    public HttpStatus getHttpStatus() {

        return httpStatus;
    }

    public ResourceNotFoundException(String message) {

        super(message);
    }

    public ResourceNotFoundException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
