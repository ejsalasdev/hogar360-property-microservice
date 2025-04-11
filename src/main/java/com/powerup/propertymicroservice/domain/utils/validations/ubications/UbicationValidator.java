package com.powerup.propertymicroservice.domain.utils.validations.ubications;

import com.powerup.propertymicroservice.domain.exceptions.InvalidNameFormatException;
import com.powerup.propertymicroservice.domain.exceptions.NameMaxSizeExceededException;
import com.powerup.propertymicroservice.domain.exceptions.RequiredFieldNullOrEmptyException;
import com.powerup.propertymicroservice.domain.utils.constants.DomainConstants;
import com.powerup.propertymicroservice.domain.utils.constants.ubications.UbicationConstants;
import com.powerup.propertymicroservice.domain.utils.constants.ubications.UbicationExceptionMessagesConstants;

import static com.powerup.propertymicroservice.domain.utils.constants.DomainConstants.VALID_FORMAT_REGEX;
import static com.powerup.propertymicroservice.domain.utils.validations.ValidationUtils.isInvalidFormat;

public class UbicationValidator {

    public void validateSectorName(String sectorName) {
        if (sectorName == null) {
            throw new RequiredFieldNullOrEmptyException(DomainConstants.FIELD_SECTOR_NAME_NULL_MESSAGE);
        }
        String trimmedName = sectorName.trim();
        if (trimmedName.isEmpty()){
            throw new RequiredFieldNullOrEmptyException(DomainConstants.FIELD_SECTOR_NAME_EMPTY_MESSAGE);
        }
        if (trimmedName.length() > UbicationConstants.NAME_MAX_LENGTH) {
            throw new NameMaxSizeExceededException(UbicationExceptionMessagesConstants.UBICATION_NAME_MAX_SIZE_MESSAGE);
        }
        if (isInvalidFormat(trimmedName, VALID_FORMAT_REGEX)) {
            throw new InvalidNameFormatException(String.format(UbicationExceptionMessagesConstants.INVALID_UBICATION_NAME_FORMAT_MESSAGE,trimmedName));
        }
    }
    
    
}
