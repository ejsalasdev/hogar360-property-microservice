package com.powerup.propertymicroservice.domain.utils.validations.categories;

import com.powerup.propertymicroservice.domain.exceptions.InvalidPageNumberException;
import com.powerup.propertymicroservice.domain.exceptions.InvalidPageSizeException;
import com.powerup.propertymicroservice.domain.exceptions.RequiredFieldNullOrEmptyException;
import com.powerup.propertymicroservice.domain.utils.constants.PaginationConstants;
import com.powerup.propertymicroservice.domain.utils.constants.categories.CategoriesExceptionsMessagesConstants;

public class CategoryPaginationValidator {

    public void validatePage(Integer page) {
        if (page == null) {
            throw new RequiredFieldNullOrEmptyException(CategoriesExceptionsMessagesConstants.FIELD_PAGE_NULL_MESSAGE);
        }
        if (page < PaginationConstants.MIN_PAGE_NUMBER) {
            throw new InvalidPageNumberException(CategoriesExceptionsMessagesConstants.PAGE_NUMBER_NEGATIVE_MESSAGE);
        }
    }

    public void validateSize(Integer size) {
        if (size == null) {
            throw new RequiredFieldNullOrEmptyException(CategoriesExceptionsMessagesConstants.FIELD_SIZE_NULL_MESSAGE);
        }
        if (size < PaginationConstants.MIN_PAGE_SIZE) {
            throw new InvalidPageSizeException(CategoriesExceptionsMessagesConstants.PAGE_SIZE_NEGATIVE_OR_ZERO_MESSAGE);
        }
        if (size > PaginationConstants.MAX_PAGE_SIZE) {
            throw new InvalidPageSizeException(CategoriesExceptionsMessagesConstants.PAGE_SIZE_MAX_EXCEEDED_MESSAGE);
        }
    }
}
