package com.powerup.propertymicroservice.domain.validations;

import com.powerup.propertymicroservice.domain.exceptions.*;
import com.powerup.propertymicroservice.domain.utils.constants.CategoryValidationConstants;
import com.powerup.propertymicroservice.domain.utils.constants.DomainConstants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.powerup.propertymicroservice.domain.utils.constants.CategoryValidationConstants.NAME_REGEX;

public class CategoryValidator {

    private static final Pattern NAME_PATTERN = Pattern.compile(NAME_REGEX);

    public void validateName(String name) {
        if (name == null) {
            throw new RequiredFieldNullOrEmptyException(DomainConstants.FIELD_NAME_NULL_MESSAGE);
        }
        String trimmedName = name.trim();
        if (trimmedName.isEmpty()) {
            throw new RequiredFieldNullOrEmptyException(DomainConstants.FIELD_NAME_NULL_MESSAGE);
        }
        if (trimmedName.length() > CategoryValidationConstants.NAME_MAX_LENGTH) {
            throw new NameMaxSizeExceededException(DomainConstants.NAME_MAX_SIZE_MESSAGE);
        }
        if (isInvalidFormat(trimmedName)) {
            throw new InvalidCategoryNameFormatException(DomainConstants.INVALID_CATEGORY_NAME_FORMAT_MESSAGE);
        }
    }
    
    public void validateDescription(String description){
        if (description == null) {
            throw new RequiredFieldNullOrEmptyException(DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        }
        String trimmedDescription = description.trim();
        if (trimmedDescription.isEmpty()) {
            throw new RequiredFieldNullOrEmptyException(DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        }
        if (trimmedDescription.length() > CategoryValidationConstants.DESCRIPTION_MAX_LENGTH) {
            throw new DescriptionMaxSizeExceededException(DomainConstants.DESCRIPTION_MAX_SIZE_MESSAGE);
        }
        if (isInvalidFormat(trimmedDescription)) {
            throw new InvalidCategoryDescriptionFormatException(DomainConstants.INVALID_CATEGORY_DESCRIPTION_FORMAT_MESSAGE);
        }
    }


    private boolean isInvalidFormat(String string) {
        Matcher matcher = NAME_PATTERN.matcher(string);
        return !matcher.matches();
    }
}
