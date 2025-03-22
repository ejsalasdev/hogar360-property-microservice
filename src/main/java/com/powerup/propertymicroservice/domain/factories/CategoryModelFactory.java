package com.powerup.propertymicroservice.domain.factories;

import com.powerup.propertymicroservice.domain.model.CategoryModel;

public class CategoryModelFactory {

    public static CategoryModel createCategoryModel(Long id, String name, String description) {
        return new CategoryModel(id, name, description);
    }

    public static CategoryModel createCategoryModelWithNullName(String description) {
        return createCategoryModel(null, null, description);
    }

    public static CategoryModel createCategoryModelWithValidName(String description) {
        return createCategoryModel(null, "Valid Name", description);
    }

    public static CategoryModel createCategoryModelWithNewCategory(String description){
        return createCategoryModel(null, "New Category", description);
    }
}
