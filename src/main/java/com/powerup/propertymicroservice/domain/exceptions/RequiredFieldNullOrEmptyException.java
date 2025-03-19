package com.powerup.propertymicroservice.domain.exceptions;

public class RequiredFieldNullOrEmptyException extends RuntimeException{

    public RequiredFieldNullOrEmptyException(String message) {
        super(message);
    }
}
