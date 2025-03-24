package com.powerup.propertymicroservice.domain.exceptions;

public class NameMaxSizeExceededException extends IllegalArgumentException {
    
    public NameMaxSizeExceededException(String s) {
        super(s);
    }
}
