package com.powerup.propertymicroservice.domain.utils.constants;

public final class DomainConstants {

    private DomainConstants() {
        throw new IllegalStateException("Utility Class");
    }

    public static final String NAME_MAX_SIZE_MESSAGE = "The name of the category can not exceed 50 characters";
    public static final String DESCRIPTION_MAX_SIZE_MESSAGE = "The description of the category can not exceed 90 characters";
    public static final String CATEGORY_EXISTS_EXCEPTION = "The category already exists";
    public static final String FIELD_NAME_NULL_MESSAGE = "Field 'name' can not be null or empty";
    public static final String FIELD_DESCRIPTION_NULL_MESSAGE = "Field 'description' can not be null or empty";
    public static final String INVALID_CATEGORY_NAME_FORMAT_MESSAGE = "Category name contains invalid characters. Only letters, numbers, underscore, and space are allowed.";
}
