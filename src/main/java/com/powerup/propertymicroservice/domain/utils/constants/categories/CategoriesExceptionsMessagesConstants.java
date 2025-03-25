package com.powerup.propertymicroservice.domain.utils.constants.categories;

public final class CategoriesExceptionsMessagesConstants {
   
    // Messages for create categories
    public static final String CATEGORY_NAME_MAX_SIZE_MESSAGE = "The name of the category can not exceed 50 characters";
    public static final String DESCRIPTION_MAX_SIZE_MESSAGE = "The description of the category can not exceed 90 characters";
    public static final String CATEGORY_EXISTS_EXCEPTION = "The category already exists";
    public static final String INVALID_CATEGORY_NAME_FORMAT_MESSAGE = "Category name contains invalid characters. Only letters, numbers, underscore, and space are allowed.";
    public static final String INVALID_CATEGORY_DESCRIPTION_FORMAT_MESSAGE = "Category description contains invalid characters. Only letters, numbers, underscore, and space are allowed.";
    
    
    // Messages for pagination
    public static final String FIELD_PAGE_NULL_MESSAGE = "Field 'page' can not be null";
    public static final String FIELD_SIZE_NULL_MESSAGE = "Field 'size' can not be null";
    public static final String PAGE_NUMBER_NEGATIVE_MESSAGE = "Page number cannot be negative.";
    public static final String PAGE_SIZE_NEGATIVE_OR_ZERO_MESSAGE = "Page size cannot be negative or zero.";
    public static final String PAGE_SIZE_MAX_EXCEEDED_MESSAGE = "Page size exceeds maximum allowed.";
    public static final String INVALID_PAGE_INPUT_FORMAT_MESSAGE = "Page input contains invalid characters. Only numbers are allowed.";
    public static final String INVALID_SIZE_INPUT_FORMAT_MESSAGE = "Size input contains invalid characters. Only numbers are allowed.";

    private CategoriesExceptionsMessagesConstants() {
        throw new IllegalStateException("Utility Class");
    }
}
