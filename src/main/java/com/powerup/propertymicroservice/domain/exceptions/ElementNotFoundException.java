package com.powerup.propertymicroservice.domain.exceptions;

public class ElementNotFoundException extends RuntimeException{

    public ElementNotFoundException(String s) {
        super(s);
    }
}
