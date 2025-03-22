package com.powerup.propertymicroservice.domain.exceptions;

public class InvalidPageNumberException extends IllegalArgumentException{

    public InvalidPageNumberException(String s) {
        super(s);
    }
}
