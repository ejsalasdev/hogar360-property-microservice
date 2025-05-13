package com.powerup.propertymicroservice.domain.exceptions;

public class CategoryInUseException extends RuntimeException {
    public CategoryInUseException(String message) {
        super(message);
    }
}
