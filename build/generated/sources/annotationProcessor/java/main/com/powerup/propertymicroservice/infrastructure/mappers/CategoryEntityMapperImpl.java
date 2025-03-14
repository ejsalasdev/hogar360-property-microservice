package com.powerup.propertymicroservice.infrastructure.mappers;

import com.powerup.propertymicroservice.domain.model.CategoryModel;
import com.powerup.propertymicroservice.infrastructure.entities.CategoryEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-14T00:24:40-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class CategoryEntityMapperImpl implements CategoryEntityMapper {

    @Override
    public CategoryEntity modelToEntity(CategoryModel categoryModel) {
        if ( categoryModel == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        return categoryEntity;
    }

    @Override
    public CategoryModel entityToModel(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String description = null;

        CategoryModel categoryModel = new CategoryModel( id, name, description );

        return categoryModel;
    }

    @Override
    public List<CategoryModel> entityListToModelList(List<CategoryEntity> categories) {
        if ( categories == null ) {
            return null;
        }

        List<CategoryModel> list = new ArrayList<CategoryModel>( categories.size() );
        for ( CategoryEntity categoryEntity : categories ) {
            list.add( entityToModel( categoryEntity ) );
        }

        return list;
    }
}
