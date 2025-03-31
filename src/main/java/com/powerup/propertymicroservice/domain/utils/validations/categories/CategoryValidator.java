package com.powerup.propertymicroservice.domain.utils.validations.categories;

import com.powerup.propertymicroservice.domain.exceptions.*;
import com.powerup.propertymicroservice.domain.utils.constants.CommonConstants;
import com.powerup.propertymicroservice.domain.utils.constants.categories.CategoryConstants;
import com.powerup.propertymicroservice.domain.utils.constants.categories.CategoriesExceptionsMessagesConstants;

import static com.powerup.propertymicroservice.domain.utils.validations.ValidationUtils.isInvalidFormat;
import static com.powerup.propertymicroservice.domain.utils.constants.CommonConstants.VALID_FORMAT_REGEX;

public class CategoryValidator {

    public void validateName(String name) {
        if (name == null) {
            throw new RequiredFieldNullOrEmptyException(CommonConstants.FIELD_NAME_NULL_MESSAGE);
        }
        String trimmedName = name.trim();
        if (trimmedName.isEmpty()) {
            throw new RequiredFieldNullOrEmptyException(CommonConstants.FIELD_NAME_EMPTY_MESSAGE);
        }
        if (trimmedName.length() > CategoryConstants.NAME_MAX_LENGTH) {
            throw new NameMaxSizeExceededException(CategoriesExceptionsMessagesConstants.CATEGORY_NAME_MAX_SIZE_MESSAGE);
        }
        if (isInvalidFormat(trimmedName, VALID_FORMAT_REGEX)) {
            throw new InvalidNameFormatException(CategoriesExceptionsMessagesConstants.INVALID_CATEGORY_NAME_FORMAT_MESSAGE);
        }
    }

    public void validateDescription(String description) {
        if (description == null) {
            throw new RequiredFieldNullOrEmptyException(CommonConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        }
        String trimmedDescription = description.trim();
        if (trimmedDescription.isEmpty()) {
            throw new RequiredFieldNullOrEmptyException(CommonConstants.FIELD_DESCRIPTION_EMPTY_MESSAGE);
        }
        if (trimmedDescription.length() > CategoryConstants.DESCRIPTION_MAX_LENGTH) {
            throw new DescriptionMaxSizeExceededException(CategoriesExceptionsMessagesConstants.CATEGORY_DESCRIPTION_MAX_SIZE_MESSAGE);
        }
        if (isInvalidFormat(trimmedDescription, VALID_FORMAT_REGEX)) {
            throw new InvalidDescriptionFormatException(CategoriesExceptionsMessagesConstants.INVALID_CATEGORY_DESCRIPTION_FORMAT_MESSAGE);
        }
    }
}
