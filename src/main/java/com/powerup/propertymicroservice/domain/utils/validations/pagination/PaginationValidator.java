package com.powerup.propertymicroservice.domain.utils.validations.pagination;

import com.powerup.propertymicroservice.domain.exceptions.InvalidPageNumberException;
import com.powerup.propertymicroservice.domain.exceptions.InvalidPageSizeException;
import com.powerup.propertymicroservice.domain.exceptions.RequiredFieldNullOrEmptyException;
import com.powerup.propertymicroservice.domain.utils.constants.pagination.PaginationConstants;
import com.powerup.propertymicroservice.domain.utils.constants.pagination.PaginationExceptionsMessagesConstants;

public class PaginationValidator {

    public void validatePage(Integer page) {
        if (page == null) {
            throw new RequiredFieldNullOrEmptyException(PaginationExceptionsMessagesConstants.FIELD_PAGE_NULL_MESSAGE);
        }
        if (page < PaginationConstants.MIN_PAGE_NUMBER) {
            throw new InvalidPageNumberException(PaginationExceptionsMessagesConstants.PAGE_NUMBER_NEGATIVE_MESSAGE);
        }
    }

    public void validateSize(Integer size) {
        if (size == null) {
            throw new RequiredFieldNullOrEmptyException(PaginationExceptionsMessagesConstants.FIELD_SIZE_NULL_MESSAGE);
        }
        if (size < PaginationConstants.MIN_PAGE_SIZE) {
            throw new InvalidPageSizeException(PaginationExceptionsMessagesConstants.PAGE_SIZE_NEGATIVE_OR_ZERO_MESSAGE);
        }
        if (size > PaginationConstants.MAX_PAGE_SIZE) {
            throw new InvalidPageSizeException(PaginationExceptionsMessagesConstants.PAGE_SIZE_MAX_EXCEEDED_MESSAGE);
        }
    }
}
