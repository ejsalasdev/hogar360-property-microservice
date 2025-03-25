package com.powerup.propertymicroservice.domain.utils.constants.categories;

public final class CategoryConstants {

    public static final int NAME_MAX_LENGTH = 50;
    public static final int DESCRIPTION_MAX_LENGTH = 90;

    public static final String SAVE_CATEGORY_RESPONSE_MESSAGE = "Category created successfully.";

    private CategoryConstants() {
        throw new IllegalStateException("Utility Class");
    }
}
