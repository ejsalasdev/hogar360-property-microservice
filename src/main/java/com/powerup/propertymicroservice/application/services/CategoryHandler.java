package com.powerup.propertymicroservice.application.services;

import com.powerup.propertymicroservice.application.dto.request.SaveCategoryRequest;
import com.powerup.propertymicroservice.application.dto.response.CategoryResponse;
import com.powerup.propertymicroservice.application.dto.response.SaveCategoryResponse;

import java.util.List;

public interface CategoryHandler {
    
    SaveCategoryResponse save(SaveCategoryRequest saveCategoryRequest);
    List<CategoryResponse> getCategories(Integer page, Integer size, boolean orderAsc);
}
