package com.powerup.propertymicroservice.domain.ports.in;

import com.powerup.propertymicroservice.domain.model.CategoryModel;
import com.powerup.propertymicroservice.domain.model.PageInfo;


public interface CategoryServicePort {

    void save(CategoryModel categoryModel);

    PageInfo<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc);
}