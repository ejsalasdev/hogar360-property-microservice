package com.powerup.propertymicroservice.application.services.impl;

import com.powerup.propertymicroservice.application.dto.request.SaveCategoryRequest;
import com.powerup.propertymicroservice.application.dto.response.CategoryResponse;
import com.powerup.propertymicroservice.application.dto.response.SaveCategoryResponse;
import com.powerup.propertymicroservice.application.mappers.CategoryDtoMapper;
import com.powerup.propertymicroservice.application.services.CategoryHandler;
import com.powerup.propertymicroservice.domain.model.CategoryModel;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;
import com.powerup.propertymicroservice.domain.ports.in.CategoryServicePort;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.Utils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.powerup.propertymicroservice.domain.utils.constants.categories.CategoryConstants.SAVE_CATEGORY_RESPONSE_MESSAGE;

@Service
@RequiredArgsConstructor
public class CategoryHandlerImpl implements CategoryHandler {

    private final CategoryServicePort categoryServicePort;
    private final CategoryDtoMapper categoryDtoMapper;

    @Override
    public SaveCategoryResponse save(SaveCategoryRequest request) {
        categoryServicePort.save(categoryDtoMapper.requestToModel(request));
        return new SaveCategoryResponse(SAVE_CATEGORY_RESPONSE_MESSAGE, LocalDateTime.now());
    }

    @Override
    public PageInfo<CategoryResponse> getCategories(Integer page, Integer size, boolean orderAsc) {
        PageInfo<CategoryModel> categoryPageInfo = categoryServicePort.getCategories(page, size, orderAsc);
        List<CategoryResponse> categoryResponses = categoryPageInfo.getContent().stream()
                .map(categoryDtoMapper::modelToResponse)
                .toList();

        return new PageInfo<>(
                categoryResponses,
                categoryPageInfo.getTotalElements(),
                categoryPageInfo.getTotalPages(),
                categoryPageInfo.getCurrentPage(),
                categoryPageInfo.getPageSize(),
                categoryPageInfo.isHasNext(),
                categoryPageInfo.isHasPrevious()
        );
    }
}