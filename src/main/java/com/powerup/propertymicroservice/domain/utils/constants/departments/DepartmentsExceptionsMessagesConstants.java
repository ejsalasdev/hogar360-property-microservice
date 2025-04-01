package com.powerup.propertymicroservice.domain.utils.constants.departments;

public class DepartmentsExceptionsMessagesConstants {

    // Messages for department
    public static final String DEPARTMENT_NAME_MAX_SIZE_MESSAGE = "The name of the department can not exceed 50 characters";
    public static final String DEPARTMENT_DESCRIPTION_MAX_SIZE_MESSAGE = "The description of the department can not exceed 120 characters";
    public static final String DEPARTMENT_EXISTS_EXCEPTION = "The department '%s' already exists";
    public static final String DEPARTMENT_NOT_FOUND_EXCEPTION = "No department was found with the name: '%s'";
    public static final String INVALID_DEPARTMENT_NAME_FORMAT_MESSAGE = "Department name '%s' contains invalid characters. Only letters and space are allowed.";
    public static final String INVALID_DEPARTMENT_DESCRIPTION_FORMAT_MESSAGE = "Department description '%s' contains invalid characters. Only letters and space are allowed.";

    private DepartmentsExceptionsMessagesConstants() {
        throw new IllegalStateException("Utility Class");
    }
}
