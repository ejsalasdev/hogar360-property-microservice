package com.powerup.propertymicroservice.domain.exceptions;

public class ElementAlreadyExistsException extends IllegalArgumentException{

    public ElementAlreadyExistsException(String s) {
        super(s);
    }
}
