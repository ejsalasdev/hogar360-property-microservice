package com.powerup.propertymicroservice.domain.utils.constants.ubications;

public final class UbicationsExceptionsMessagesConstants {
   
    // Messages for create ubications
    public static final String UBICATION_NAME_MAX_SIZE_MESSAGE = "The name of the ubication can not exceed 50 characters";
    public static final String UBICATION_DESCRIPTION_MAX_SIZE_MESSAGE = "The description of the ubication can not exceed 120 characters";
    
    public static final String UBICATION_EXISTS_EXCEPTION = "The ubication already exists: ";
    public static final String INVALID_UBICATION_NAME_FORMAT_MESSAGE = "Ubication name contains invalid characters. Only letters, numbers, underscore, and space are allowed.";
    public static final String INVALID_UBICATION_DESCRIPTION_FORMAT_MESSAGE = "Ubication description contains invalid characters. Only letters, numbers, underscore, and space are allowed.";
    
    // Messages for department
    public static final String DEPARTMENT_NAME_MAX_SIZE_MESSAGE = "The name of the department can not exceed 50 characters";
    public static final String DEPARTMENT_DESCRIPTION_MAX_SIZE_MESSAGE = "The description of the department can not exceed 120 characters";
    public static final String DEPARTMENT_EXISTS_EXCEPTION = "The department already exists: ";
    public static final String INVALID_DEPARTMENT_NAME_FORMAT_MESSAGE = "Department name contains invalid characters. Only letters, numbers, underscore, and space are allowed.";
    public static final String INVALID_DEPARTMENT_DESCRIPTION_FORMAT_MESSAGE = "Department description contains invalid characters. Only letters, numbers, underscore, and space are allowed.";
    
    // Messages for city
    public static final String CITY_NAME_MAX_SIZE_MESSAGE = "The name of the city can not exceed 50 characters";
    public static final String CITY_DESCRIPTION_MAX_SIZE_MESSAGE = "The description of the city can not exceed 120 characters";
    public static final String CITY_EXISTS_EXCEPTION = "The city already exists: ";
    public static final String INVALID_CITY_NAME_FORMAT_MESSAGE = "City name contains invalid characters. Only letters, numbers, underscore, and space are allowed.";
    public static final String INVALID_CITY_DESCRIPTION_FORMAT_MESSAGE = "City description contains invalid characters. Only letters, numbers, underscore, and space are allowed.";
    
    // Messages for pagination
    public static final String FIELD_PAGE_NULL_MESSAGE = "Field 'page' can not be null";
    public static final String FIELD_SIZE_NULL_MESSAGE = "Field 'size' can not be null";
    public static final String PAGE_NUMBER_NEGATIVE_MESSAGE = "Page number cannot be negative.";
    public static final String PAGE_SIZE_NEGATIVE_OR_ZERO_MESSAGE = "Page size cannot be negative or zero.";
    public static final String PAGE_SIZE_MAX_EXCEEDED_MESSAGE = "Page size exceeds maximum allowed.";
    public static final String INVALID_PAGE_INPUT_FORMAT_MESSAGE = "Page input contains invalid characters. Only numbers are allowed.";
    public static final String INVALID_SIZE_INPUT_FORMAT_MESSAGE = "Size input contains invalid characters. Only numbers are allowed.";

    private UbicationsExceptionsMessagesConstants() {
        throw new IllegalStateException("Utility Class");
    }
}
