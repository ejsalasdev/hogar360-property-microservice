package com.powerup.propertymicroservice.domain.exceptions;

public class InvalidCategoryNameFormatException extends RuntimeException{

    public InvalidCategoryNameFormatException(String message) {
        super(message);
    }
}
