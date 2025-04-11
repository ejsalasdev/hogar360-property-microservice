package com.powerup.propertymicroservice.domain.utils.constants;

public final class DomainConstants {

    public static final String FIELD_NAME_NULL_MESSAGE = "Field 'name' is null";
    public static final String FIELD_NAME_EMPTY_MESSAGE = "Field 'name' can not be empty";
    public static final String FIELD_CITY_NAME_NULL_MESSAGE = "Field 'cityName' is null";
    public static final String FIELD_CITY_NAME_EMPTY_MESSAGE = "Field 'cityName' can not be empty";
    public static final String FIELD_SECTOR_NAME_NULL_MESSAGE = "Field 'sector' is null";
    public static final String FIELD_SECTOR_NAME_EMPTY_MESSAGE = "Field 'sector' can not be empty";
    public static final String FIELD_DESCRIPTION_NULL_MESSAGE = "Field 'description' is null";
    public static final String FIELD_DESCRIPTION_EMPTY_MESSAGE = "Field 'description' can not be empty";
    public static final String VALID_FORMAT_REGEX = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$";

    private DomainConstants() {
        throw new IllegalStateException("Utility Class");
    }
}
