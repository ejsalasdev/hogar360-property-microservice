package com.powerup.propertymicroservice.domain.utils.constants.categories;

public final class CategoriesExceptionsMessagesConstants {
   
    // Messages for create categories
    public static final String CATEGORY_NAME_MAX_SIZE_MESSAGE = "The name of the category can not exceed 50 characters";
    public static final String CATEGORY_DESCRIPTION_MAX_SIZE_MESSAGE = "The description of the category can not exceed 90 characters";
    public static final String CATEGORY_EXISTS_EXCEPTION = "The category '%s' already exists";
    public static final String INVALID_CATEGORY_NAME_FORMAT_MESSAGE = "Category name contains invalid characters. Only letters, numbers, underscore, and space are allowed.";
    public static final String INVALID_CATEGORY_DESCRIPTION_FORMAT_MESSAGE = "Category description contains invalid characters. Only letters, numbers, underscore, and space are allowed.";
    public static final String CATEGORY_NOT_FOUND_EXCEPTION = "No category was found with the id '%s'.";
    public static final String CATEGORY_IN_USE_EXCEPTION = "Category with id %d cannot be deleted because it is in use";

    private CategoriesExceptionsMessagesConstants() {
        throw new IllegalStateException("Utility Class");
    }
}
