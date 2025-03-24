package com.powerup.propertymicroservice.domain.exceptions;

public class RequiredFieldNullOrEmptyException extends IllegalArgumentException{

    public RequiredFieldNullOrEmptyException(String s) {
        super(s);
    }
}
