package com.powerup.propertymicroservice.domain.utils.constants.cities;

import java.util.Locale;

public final class CitiesExceptionsMessagesConstants {

    // Messages for city
    public static final String CITY_NAME_MAX_SIZE_MESSAGE = "The name of the city can not exceed 50 characters";
    public static final String CITY_DESCRIPTION_MAX_SIZE_MESSAGE = "The description of the city can not exceed 120 characters";
    public static final String CITY_EXISTS_EXCEPTION = "The city already exists: ";
    public static final String CITY_NOT_FOUND_EXCEPTION = "No city was found with the name: '%s'";
    public static final String CITY_AMBIGOUS_FOUND_EXCEPTION = "%d cities were found with the name '%s'. Please try again providing the departmentName field.";
    public static final String CITY_NOT_FOUND_IN_DEPARTMENT_EXCEPTION = "No city '%s' was found in the department '%s'";
    public static final String CITY_ALREADY_EXISTS_IN_DEPARTMENT_EXCEPTION = "A city with the name '%s' already exists in this department.";
    public static final String INVALID_CITY_NAME_FORMAT_MESSAGE = "City name '%s' contains invalid characters. Only letters and space are allowed.";
    public static final String INVALID_CITY_DESCRIPTION_FORMAT_MESSAGE = "City description '%s' contains invalid characters. Only letters, numbers, underscore, and space are allowed.";

    private CitiesExceptionsMessagesConstants() {
        throw new IllegalStateException("Utility Class");
    }
}
