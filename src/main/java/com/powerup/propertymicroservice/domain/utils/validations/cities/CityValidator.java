package com.powerup.propertymicroservice.domain.utils.validations.cities;

import com.powerup.propertymicroservice.domain.exceptions.*;
import com.powerup.propertymicroservice.domain.utils.constants.CommonConstants;
import com.powerup.propertymicroservice.domain.utils.constants.cities.CitiesExceptionsMessagesConstants;
import com.powerup.propertymicroservice.domain.utils.constants.cities.CityConstants;


import static com.powerup.propertymicroservice.domain.utils.validations.ValidationUtils.isInvalidFormat;
import static com.powerup.propertymicroservice.domain.utils.constants.CommonConstants.VALID_FORMAT_REGEX;

public class CityValidator {

    public void validateCityName(String name) {
        if (name == null) {
            throw new RequiredFieldNullOrEmptyException(CommonConstants.FIELD_CITY_NAME_NULL_MESSAGE);
        }
        String trimmedName = name.trim();
        if (trimmedName.isEmpty()){
            throw new RequiredFieldNullOrEmptyException(CommonConstants.FIELD_CITY_NAME_EMPTY_MESSAGE);
        }
        if (trimmedName.length() > CityConstants.NAME_MAX_LENGTH) {
            throw new NameMaxSizeExceededException(CitiesExceptionsMessagesConstants.CITY_NAME_MAX_SIZE_MESSAGE);
        }
        if (isInvalidFormat(trimmedName, VALID_FORMAT_REGEX)) {
            throw new InvalidNameFormatException(String.format(CitiesExceptionsMessagesConstants.INVALID_CITY_NAME_FORMAT_MESSAGE,trimmedName));
        }
    }

    public void validateCityDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new RequiredFieldNullOrEmptyException(CommonConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        }
        String trimmedDescription = description.trim();
        if (trimmedDescription.length() > CityConstants.DESCRIPTION_MAX_LENGTH) {
            throw new DescriptionMaxSizeExceededException(CitiesExceptionsMessagesConstants.CITY_DESCRIPTION_MAX_SIZE_MESSAGE);
        }
        if (isInvalidFormat(trimmedDescription, VALID_FORMAT_REGEX)) {
            throw new InvalidDescriptionFormatException(CitiesExceptionsMessagesConstants.INVALID_CITY_DESCRIPTION_FORMAT_MESSAGE);
        }
    }
}