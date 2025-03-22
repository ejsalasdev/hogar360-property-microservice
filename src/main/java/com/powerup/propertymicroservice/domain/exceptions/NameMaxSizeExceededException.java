package com.powerup.propertymicroservice.domain.exceptions;

public class NameMaxSizeExceededException extends RuntimeException {
    
    public NameMaxSizeExceededException(String message) {
        super(message);
    }
}
