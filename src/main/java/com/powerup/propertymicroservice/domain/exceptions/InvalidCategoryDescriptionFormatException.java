package com.powerup.propertymicroservice.domain.exceptions;

public class InvalidCategoryDescriptionFormatException extends RuntimeException{

    public InvalidCategoryDescriptionFormatException(String message) {
        super(message);
    }
}
