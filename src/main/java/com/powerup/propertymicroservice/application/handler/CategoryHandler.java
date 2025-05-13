package com.powerup.propertymicroservice.application.handler;

import com.powerup.propertymicroservice.application.dto.request.SaveCategoryRequest;
import com.powerup.propertymicroservice.application.dto.response.CategoryResponse;
import com.powerup.propertymicroservice.application.dto.response.DeleteCategoryResponse;
import com.powerup.propertymicroservice.application.dto.response.SaveCategoryResponse;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;


public interface CategoryHandler {

    SaveCategoryResponse save(SaveCategoryRequest saveCategoryRequest);
    PageInfo<CategoryResponse> getCategories(Integer page, Integer size, boolean orderAsc);
    DeleteCategoryResponse delete(Long id);
}
