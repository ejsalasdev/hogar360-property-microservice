package com.powerup.propertymicroservice.application.handler.impl;

import com.powerup.propertymicroservice.application.dto.request.SaveCategoryRequest;
import com.powerup.propertymicroservice.application.dto.response.CategoryResponse;
import com.powerup.propertymicroservice.application.dto.response.DeleteCategoryResponse;
import com.powerup.propertymicroservice.application.dto.response.SaveCategoryResponse;
import com.powerup.propertymicroservice.application.handler.CategoryHandler;
import com.powerup.propertymicroservice.application.mappers.CategoryRequestMapper;
import com.powerup.propertymicroservice.application.mappers.CategoryResponseMapper;
import com.powerup.propertymicroservice.application.utils.constants.ApplicationConstants;
import com.powerup.propertymicroservice.domain.model.CategoryModel;
import com.powerup.propertymicroservice.domain.ports.in.CategoryServicePort;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryHandlerImpl implements CategoryHandler {

    private final CategoryServicePort categoryServicePort;
    private final CategoryRequestMapper categoryRequestMapper;
    private final CategoryResponseMapper categoryResponseMapper;

    @Override
    public SaveCategoryResponse save(SaveCategoryRequest request) {
        categoryServicePort.save(categoryRequestMapper.requestToModel(request));
        return new SaveCategoryResponse(ApplicationConstants.SAVE_CATEGORY_RESPONSE_MESSAGE, LocalDateTime.now());
    }

    @Override
    public PageInfo<CategoryResponse> getCategories(Integer page, Integer size, boolean orderAsc) {
        PageInfo<CategoryModel> categoryPageInfo = categoryServicePort.getCategories(page, size, orderAsc);
        List<CategoryResponse> categoryResponses = categoryPageInfo.getContent().stream()
                .map(categoryResponseMapper::modelToResponse)
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

    @Override
    public DeleteCategoryResponse delete(Long id) {
        categoryServicePort.deleteById(id);
        return new DeleteCategoryResponse(ApplicationConstants.DELETE_CATEGORY_RESPONSE_MESSAGE, LocalDateTime.now());
    }
}