package com.powerup.propertymicroservice.domain.exceptions;

public class CategoryAlreadyExistsException extends IllegalArgumentException{

    public CategoryAlreadyExistsException(String s) {
        super(s);
    }
}
