package com.sula.maladhari_hotel.exceptions.custom;

import org.springframework.http.HttpStatus;

public class ResourceAlreadyExisistException extends Exception{

    public ResourceAlreadyExisistException(String message) {
        super(message);
    }

    private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }


    public ResourceAlreadyExisistException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
