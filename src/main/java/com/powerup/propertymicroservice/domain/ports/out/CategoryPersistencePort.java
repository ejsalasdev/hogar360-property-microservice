package com.powerup.propertymicroservice.domain.ports.out;

import com.powerup.propertymicroservice.domain.model.CategoryModel;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;

import java.util.Optional;

public interface CategoryPersistencePort {
    
    void save(CategoryModel categoryModel);
    Optional<CategoryModel> getCategoryByName(String categoryName);
    PageInfo<CategoryModel> getCategories(Integer page, Integer size, String sortBy, String sortDirection);
    
}
