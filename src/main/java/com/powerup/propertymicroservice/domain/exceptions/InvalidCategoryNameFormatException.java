package com.powerup.propertymicroservice.domain.exceptions;

public class InvalidCategoryNameFormatException extends IllegalArgumentException{

    public InvalidCategoryNameFormatException(String s) {
        super(s);
    }
}
