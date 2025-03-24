package com.powerup.propertymicroservice.domain.exceptions;

public class InvalidDescriptionFormatException extends IllegalArgumentException{

    public InvalidDescriptionFormatException(String s) {
        super(s);
    }
}
