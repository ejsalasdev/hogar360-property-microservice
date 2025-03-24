package com.powerup.propertymicroservice.domain.factories;

import com.powerup.propertymicroservice.domain.model.CategoryModel;

public class CategoryModelFactoryForTest {

    private CategoryModelFactoryForTest() {
    }

    public static CategoryModel createCategoryModel(Long id, String name, String description) {
        return new CategoryModel(id, name, description);
    }

    public static CategoryModel createCategoryModelWithNewCategory(String description){
        return createCategoryModel(null, "New Category", description);
    }
}
