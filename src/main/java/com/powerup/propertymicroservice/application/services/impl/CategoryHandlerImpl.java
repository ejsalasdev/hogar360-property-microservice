package com.powerup.propertymicroservice.application.services.impl;

import com.powerup.propertymicroservice.application.dto.request.SaveCategoryRequest;
import com.powerup.propertymicroservice.application.dto.response.CategoryResponse;
import com.powerup.propertymicroservice.application.dto.response.SaveCategoryResponse;
import com.powerup.propertymicroservice.application.mappers.CategoryDtoMapper;
import com.powerup.propertymicroservice.application.services.CategoryHandler;
import com.powerup.propertymicroservice.commons.configuration.utils.Constants;
import com.powerup.propertymicroservice.domain.ports.in.CategoryServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryHandlerImpl implements CategoryHandler {
    
    private final CategoryServicePort categoryServicePort;
    private final CategoryDtoMapper categoryDtoMapper;


    @Override
    public SaveCategoryResponse save(SaveCategoryRequest request) {
        categoryServicePort.save(categoryDtoMapper.requesToModel(request));
        return new SaveCategoryResponse(Constants.SAVE_CATEGORY_RESPONSE_MESSAGE, LocalDateTime.now());
    }

    @Override
    public List<CategoryResponse> getCategories(Integer page, Integer size, boolean orderAsc) {
        return categoryDtoMapper.modelListToResponseList(categoryServicePort.getCategories(page, size, orderAsc));
    }
}
