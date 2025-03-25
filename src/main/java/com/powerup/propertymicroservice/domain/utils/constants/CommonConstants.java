package com.powerup.propertymicroservice.domain.utils.constants;

public final class CommonConstants {

    public static final String FIELD_NAME_NULL_MESSAGE = "Field 'name' is null";
    public static final String FIELD_NAME_EMPTY_MESSAGE = "Field 'name' can not be empty";
    public static final String FIELD_DESCRIPTION_NULL_MESSAGE = "Field 'description' is null";
    public static final String FIELD_DESCRIPTION_EMPTY_MESSAGE = "Field 'description' can not be empty";
    public static final String VALID_FORMAT_REGEX = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$";

    private CommonConstants() {
        throw new IllegalStateException("Utility Class");
    }
}
