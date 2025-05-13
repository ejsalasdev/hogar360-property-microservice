package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.domain.exceptions.CategoryInUseException;
import com.powerup.propertymicroservice.domain.exceptions.ElementAlreadyExistsException;
import com.powerup.propertymicroservice.domain.exceptions.ElementNotFoundException;
import com.powerup.propertymicroservice.domain.model.CategoryModel;
import com.powerup.propertymicroservice.domain.ports.in.CategoryServicePort;
import com.powerup.propertymicroservice.domain.ports.in.HouseServicePort;
import com.powerup.propertymicroservice.domain.ports.out.CategoryPersistencePort;
import com.powerup.propertymicroservice.domain.utils.constants.categories.CategoriesExceptionsMessagesConstants;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;
import com.powerup.propertymicroservice.domain.utils.validations.categories.CategoryValidator;
import com.powerup.propertymicroservice.domain.utils.validations.pagination.PaginationValidator;

import java.util.Optional;


public class CategoryUseCase implements CategoryServicePort {

    private final CategoryPersistencePort categoryPersistencePort;
    private final CategoryValidator categoryValidator;
    private final PaginationValidator paginationValidator;
    private final HouseServicePort houseServicePort;


    public CategoryUseCase(CategoryPersistencePort categoryPersistencePort, CategoryValidator categoryValidator, PaginationValidator paginationValidator, HouseServicePort houseServicePort) {
        this.categoryPersistencePort = categoryPersistencePort;
        this.categoryValidator = categoryValidator;
        this.paginationValidator = paginationValidator;
        this.houseServicePort = houseServicePort;
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
    public CategoryModel getCategoryById(Long id) {
        Optional<CategoryModel> category = categoryPersistencePort.getCategoryById(id);
        if (category.isEmpty()) {
            throw new ElementNotFoundException(
                    String.format(CategoriesExceptionsMessagesConstants.CATEGORY_NOT_FOUND_EXCEPTION, id)
            );
        }
        return category.get();
    }

    @Override
    public void deleteById(Long id) {
        Optional<CategoryModel> category = categoryPersistencePort.getCategoryById(id);
        if (category.isEmpty()) {
            throw new ElementNotFoundException(
                    String.format(CategoriesExceptionsMessagesConstants.CATEGORY_NOT_FOUND_EXCEPTION, id)
            );
        }

        if (houseServicePort.existsByCategoryId(id)) {
            throw new CategoryInUseException(
                    String.format(CategoriesExceptionsMessagesConstants.CATEGORY_IN_USE_EXCEPTION, id)
            );
        }
        categoryPersistencePort.deleteById(id);
    }


}
