package com.powerup.propertymicroservice.domain.validations;

import com.powerup.propertymicroservice.domain.exceptions.*;
import com.powerup.propertymicroservice.domain.utils.constants.CategoryConstants;
import com.powerup.propertymicroservice.domain.utils.constants.DomainExceptionsMessagesConstants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.powerup.propertymicroservice.domain.utils.constants.CategoryConstants.NAME_REGEX;

public class CategoryValidator {

    private static final Pattern NAME_PATTERN = Pattern.compile(NAME_REGEX);

    public void validateName(String name) {
        if (name == null) {
            throw new RequiredFieldNullOrEmptyException(DomainExceptionsMessagesConstants.FIELD_NAME_NULL_MESSAGE);
        }
        String trimmedName = name.trim();
        if (trimmedName.isEmpty()) {
            throw new RequiredFieldNullOrEmptyException(DomainExceptionsMessagesConstants.FIELD_NAME_NULL_MESSAGE);
        }
        if (trimmedName.length() > CategoryConstants.NAME_MAX_LENGTH) {
            throw new NameMaxSizeExceededException(DomainExceptionsMessagesConstants.NAME_MAX_SIZE_MESSAGE);
        }
        if (isInvalidFormat(trimmedName)) {
            throw new InvalidCategoryNameFormatException(DomainExceptionsMessagesConstants.INVALID_CATEGORY_NAME_FORMAT_MESSAGE);
        }
    }
    
    public void validateDescription(String description){
        if (description == null) {
            throw new RequiredFieldNullOrEmptyException(DomainExceptionsMessagesConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        }
        String trimmedDescription = description.trim();
        if (trimmedDescription.isEmpty()) {
            throw new RequiredFieldNullOrEmptyException(DomainExceptionsMessagesConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        }
        if (trimmedDescription.length() > CategoryConstants.DESCRIPTION_MAX_LENGTH) {
            throw new DescriptionMaxSizeExceededException(DomainExceptionsMessagesConstants.DESCRIPTION_MAX_SIZE_MESSAGE);
        }
        if (isInvalidFormat(trimmedDescription)) {
            throw new InvalidCategoryDescriptionFormatException(DomainExceptionsMessagesConstants.INVALID_CATEGORY_DESCRIPTION_FORMAT_MESSAGE);
        }
    }


    private boolean isInvalidFormat(String string) {
        Matcher matcher = NAME_PATTERN.matcher(string);
        return !matcher.matches();
    }
}
