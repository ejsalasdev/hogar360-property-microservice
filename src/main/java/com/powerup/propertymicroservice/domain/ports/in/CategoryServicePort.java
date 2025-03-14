package com.powerup.propertymicroservice.domain.ports.in;

import com.powerup.propertymicroservice.domain.model.CategoryModel;

import java.util.List;

public interface CategoryServicePort {

    void save(CategoryModel categoryModel);

    List<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc);
}