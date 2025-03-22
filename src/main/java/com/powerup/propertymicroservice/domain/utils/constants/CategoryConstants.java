package com.powerup.propertymicroservice.domain.utils.constants;

public class CategoryConstants {

    public static final int NAME_MAX_LENGTH = 50;
    public static final int DESCRIPTION_MAX_LENGTH = 90;

    public static final String NAME_REGEX = "^[a-zA-Z0-9_ ]+$";

    private CategoryConstants() {
        throw new IllegalStateException("Utility Class");
    }
}
