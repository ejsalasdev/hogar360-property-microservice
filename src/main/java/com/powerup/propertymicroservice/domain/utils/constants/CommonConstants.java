package com.powerup.propertymicroservice.domain.utils.constants;

public final class CommonConstants {

    public static final String FIELD_NAME_NULL_OR_EMPTY_MESSAGE = "Field 'name' can not be null or empty";
    public static final String FIELD_DESCRIPTION_NULL_OR_EMPTY_MESSAGE = "Field 'description' can not be null or empty";
    public static final String VALID_FORMAT_REGEX = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$";

    private CommonConstants() {
        throw new IllegalStateException("Utility Class");
    }
}
