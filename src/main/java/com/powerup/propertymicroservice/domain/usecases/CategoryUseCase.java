package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.domain.exceptions.ElementAlreadyExistsException;
import com.powerup.propertymicroservice.domain.exceptions.ElementNotFoundException;
import com.powerup.propertymicroservice.domain.model.CategoryModel;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;
import com.powerup.propertymicroservice.domain.ports.in.CategoryServicePort;
import com.powerup.propertymicroservice.domain.ports.out.CategoryPersistencePort;
import com.powerup.propertymicroservice.domain.utils.constants.categories.CategoriesExceptionsMessagesConstants;
import com.powerup.propertymicroservice.domain.utils.validations.pagination.PaginationValidator;
import com.powerup.propertymicroservice.domain.utils.validations.categories.CategoryValidator;

import java.util.Optional;


public class CategoryUseCase implements CategoryServicePort {

    private final CategoryPersistencePort categoryPersistencePort;
    private final CategoryValidator categoryValidator;
    private final PaginationValidator paginationValidator;


    public CategoryUseCase(CategoryPersistencePort categoryPersistencePort, CategoryValidator categoryValidator, PaginationValidator paginationValidator) {
        this.categoryPersistencePort = categoryPersistencePort;
        this.categoryValidator = categoryValidator;
        this.paginationValidator = paginationValidator;
    }

    @Override
    public void save(CategoryModel categoryModel) {
        categoryValidator.validateName(categoryModel.getName());
        categoryValidator.validateDescription(categoryModel.getDescription());
        Optional<CategoryModel> category = categoryPersistencePort.getCategoryByName(categoryModel.getName());
        if (category.isPresent()) {
            throw new ElementAlreadyExistsException(String.format(CategoriesExceptionsMessagesConstants.CATEGORY_EXISTS_EXCEPTION, categoryModel.getName()));
        }
        categoryPersistencePort.save(categoryModel);
    }

    @Override
    public PageInfo<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc) {
        paginationValidator.validatePage(page);
        paginationValidator.validateSize(size);
        String sortBy = "name";
        String sortDirection = orderAsc ? "asc" : "desc";
        return categoryPersistencePort.getCategories(page, size, sortBy, sortDirection);
    }

    @Override
    public CategoryModel getCategoryByname(String categoryName) {
        Optional<CategoryModel> category = categoryPersistencePort.getCategoryByName(categoryName);
        if (category.isEmpty()) {
            throw new ElementNotFoundException(
                    String.format(CategoriesExceptionsMessagesConstants.CATEGORY_NOT_FOUND_EXCEPTION, categoryName)
            );
        }
        return category.get();
    }


}
