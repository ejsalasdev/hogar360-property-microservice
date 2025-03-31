package com.powerup.propertymicroservice.application.mappers;

import com.powerup.propertymicroservice.application.dto.response.CategoryResponse;
import com.powerup.propertymicroservice.domain.model.CategoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryResponseMapper {

    CategoryResponse modelToResponse(CategoryModel categoryModel);
    List<CategoryResponse> modelListToResponseList(List<CategoryModel> categories);
}
