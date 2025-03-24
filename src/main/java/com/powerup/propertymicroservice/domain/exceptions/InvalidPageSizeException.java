package com.powerup.propertymicroservice.domain.exceptions;

public class InvalidPageSizeException extends IllegalArgumentException{

    public InvalidPageSizeException(String s) {
        super(s);
    }
}
