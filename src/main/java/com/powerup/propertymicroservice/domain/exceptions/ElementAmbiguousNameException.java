package com.powerup.propertymicroservice.domain.exceptions;

public class ElementAmbiguousNameException extends RuntimeException{

    public ElementAmbiguousNameException(String s) {
        super(s);
    }
}
