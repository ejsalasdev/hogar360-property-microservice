package com.powerup.propertymicroservice.domain.validations;

import com.powerup.propertymicroservice.domain.exceptions.InvalidPageNumberException;
import com.powerup.propertymicroservice.domain.exceptions.InvalidPageSizeException;
import com.powerup.propertymicroservice.domain.exceptions.RequiredFieldNullOrEmptyException;
import com.powerup.propertymicroservice.domain.utils.constants.CategoryPaginationConstants;
import com.powerup.propertymicroservice.domain.utils.constants.DomainExceptionsMessagesConstants;

public class CategoryPaginationValidator {

    public void validatePage(Integer page) {
        if (page == null) {
            throw new RequiredFieldNullOrEmptyException(DomainExceptionsMessagesConstants.FIELD_PAGE_NULL_MESSAGE);
        }
        if (page < CategoryPaginationConstants.MIN_PAGE_NUMBER) {
            throw new InvalidPageNumberException(DomainExceptionsMessagesConstants.PAGE_NUMBER_NEGATIVE_MESSAGE);
        }
    }

    public void validateSize(Integer size) {
        if (size == null) {
            throw new RequiredFieldNullOrEmptyException(DomainExceptionsMessagesConstants.FIELD_SIZE_NULL_MESSAGE);
        }
        if (size < CategoryPaginationConstants.MIN_PAGE_SIZE) {
            throw new InvalidPageSizeException(DomainExceptionsMessagesConstants.PAGE_SIZE_NEGATIVE_MESSAGE);
        }
        if (size > CategoryPaginationConstants.MAX_PAGE_SIZE) {
            throw new InvalidPageSizeException(DomainExceptionsMessagesConstants.PAGE_SIZE_MAX_EXCEEDED_MESSAGE);
        }
    }
}
