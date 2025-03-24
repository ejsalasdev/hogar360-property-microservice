package com.powerup.propertymicroservice.domain.exceptions;

public class InvalidCategoryDescriptionFormatException extends IllegalArgumentException{

    public InvalidCategoryDescriptionFormatException(String s) {
        super(s);
    }
}
