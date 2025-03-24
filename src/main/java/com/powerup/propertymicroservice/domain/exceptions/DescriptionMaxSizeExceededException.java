package com.powerup.propertymicroservice.domain.exceptions;

public class DescriptionMaxSizeExceededException extends IllegalArgumentException{

    public DescriptionMaxSizeExceededException(String s) {
        super(s);
    }
}
