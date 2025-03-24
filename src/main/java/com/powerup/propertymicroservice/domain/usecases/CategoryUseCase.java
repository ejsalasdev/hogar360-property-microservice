package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.domain.exceptions.CategoryAlreadyExistsException;
import com.powerup.propertymicroservice.domain.model.CategoryModel;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;
import com.powerup.propertymicroservice.domain.ports.in.CategoryServicePort;
import com.powerup.propertymicroservice.domain.ports.out.CategoryPersistencePort;
import com.powerup.propertymicroservice.domain.utils.constants.categories.CategoriesExceptionsMessagesConstants;
import com.powerup.propertymicroservice.domain.utils.validations.categories.CategoryPaginationValidator;
import com.powerup.propertymicroservice.domain.utils.validations.categories.CategoryValidator;

import java.util.Optional;


public class CategoryUseCase implements CategoryServicePort {

    public final CategoryPersistencePort categoryPersistencePort;
    public final CategoryValidator categoryValidator;
    public final CategoryPaginationValidator categoryPaginationValidator;


    public CategoryUseCase(CategoryPersistencePort categoryPersistencePort, CategoryValidator categoryValidator, CategoryPaginationValidator categoryPaginationValidator) {
        this.categoryPersistencePort = categoryPersistencePort;
        this.categoryValidator = categoryValidator;
        this.categoryPaginationValidator = categoryPaginationValidator;
    }

    @Override
    public void save(CategoryModel categoryModel) {
        categoryValidator.validateName(categoryModel.getName());
        categoryValidator.validateDescription(categoryModel.getDescription());
        Optional<CategoryModel> category = categoryPersistencePort.getCategoryByName(categoryModel.getName());
        if (category.isPresent()) {
            throw new CategoryAlreadyExistsException(CategoriesExceptionsMessagesConstants.CATEGORY_EXISTS_EXCEPTION);
        }
        categoryPersistencePort.save(categoryModel);
    }

    @Override
    public PageInfo<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc) {
        categoryPaginationValidator.validatePage(page);
        categoryPaginationValidator.validateSize(size);
        String sortField = "name";
        String sortDirection = orderAsc ? "asc" : "desc";
        return categoryPersistencePort.getCategories(page, size, sortField, sortDirection);
    }


}
