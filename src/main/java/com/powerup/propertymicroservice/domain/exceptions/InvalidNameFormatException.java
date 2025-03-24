package com.powerup.propertymicroservice.domain.exceptions;

public class InvalidNameFormatException extends IllegalArgumentException{

    public InvalidNameFormatException(String s) {
        super(s);
    }
}
