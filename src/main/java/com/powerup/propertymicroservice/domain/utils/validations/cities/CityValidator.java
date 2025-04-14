package com.powerup.propertymicroservice.domain.utils.validations.cities;

import com.powerup.propertymicroservice.domain.exceptions.*;
import com.powerup.propertymicroservice.domain.utils.constants.DomainConstants;
import com.powerup.propertymicroservice.domain.utils.constants.cities.CitiesExceptionsMessagesConstants;
import com.powerup.propertymicroservice.domain.utils.constants.cities.CityConstants;


import static com.powerup.propertymicroservice.domain.utils.validations.ValidationUtils.isInvalidFormat;
import static com.powerup.propertymicroservice.domain.utils.constants.DomainConstants.VALID_FORMAT_REGEX;

public class CityValidator {

    public void validateCityName(String name) {
        if (name == null) {
            throw new RequiredFieldNullOrEmptyException(DomainConstants.FIELD_CITY_NAME_NULL_MESSAGE);
        }
        String trimmedName = name.trim();
        if (trimmedName.isEmpty()){
            throw new RequiredFieldNullOrEmptyException(DomainConstants.FIELD_CITY_NAME_EMPTY_MESSAGE);
        }
        if (trimmedName.length() > CityConstants.NAME_MAX_LENGTH) {
            throw new NameMaxSizeExceededException(CitiesExceptionsMessagesConstants.CITY_NAME_MAX_SIZE_MESSAGE);
        }
        if (isInvalidFormat(trimmedName, VALID_FORMAT_REGEX)) {
            throw new InvalidNameFormatException(String.format(CitiesExceptionsMessagesConstants.INVALID_CITY_NAME_FORMAT_MESSAGE,trimmedName));
        }
    }
}