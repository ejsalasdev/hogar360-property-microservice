package com.powerup.propertymicroservice.domain.exceptions;

public class InvalidFormatExcepcion extends IllegalArgumentException{

    public InvalidFormatExcepcion(String s) {
        super(s);
    }
}
