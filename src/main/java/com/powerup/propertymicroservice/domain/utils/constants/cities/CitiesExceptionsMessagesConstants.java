package com.powerup.propertymicroservice.domain.utils.constants.cities;

public final class CitiesExceptionsMessagesConstants {
    
    // Messages for city
    public static final String CITY_NAME_MAX_SIZE_MESSAGE = "The name of the city can not exceed 50 characters";
    public static final String CITY_DESCRIPTION_MAX_SIZE_MESSAGE = "The description of the city can not exceed 120 characters";
    public static final String CITY_EXISTS_EXCEPTION = "The city already exists: ";
    public static final String CITY_NOT_FOUND_EXCEPTION = "No city was found with the name: '%s'";
    public static final String CITY_ALREADY_EXISTS_IN_DEPARTMENT_EXCEPTION = "A city with the name '%s' already exists in this department.";
    public static final String INVALID_CITY_NAME_FORMAT_MESSAGE = "City name '%s' contains invalid characters. Only letters, numbers, underscore, and space are allowed.";
    public static final String INVALID_CITY_DESCRIPTION_FORMAT_MESSAGE = "City description '%s' contains invalid characters. Only letters, numbers, underscore, and space are allowed.";
    
    // Messages for pagination
    public static final String FIELD_PAGE_NULL_MESSAGE = "Field 'page' can not be null";
    public static final String FIELD_SIZE_NULL_MESSAGE = "Field 'size' can not be null";
    public static final String PAGE_NUMBER_NEGATIVE_MESSAGE = "Page number cannot be negative.";
    public static final String PAGE_SIZE_NEGATIVE_OR_ZERO_MESSAGE = "Page size cannot be negative or zero.";
    public static final String PAGE_SIZE_MAX_EXCEEDED_MESSAGE = "Page size exceeds maximum allowed.";
    public static final String INVALID_PAGE_INPUT_FORMAT_MESSAGE = "Page input contains invalid characters. Only numbers are allowed.";
    public static final String INVALID_SIZE_INPUT_FORMAT_MESSAGE = "Size input contains invalid characters. Only numbers are allowed.";

    private CitiesExceptionsMessagesConstants() {
        throw new IllegalStateException("Utility Class");
    }
}
