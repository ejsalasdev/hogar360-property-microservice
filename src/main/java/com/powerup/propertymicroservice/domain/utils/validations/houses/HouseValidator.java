package com.powerup.propertymicroservice.domain.utils.validations.houses;

import com.powerup.propertymicroservice.domain.exceptions.*;
import com.powerup.propertymicroservice.domain.model.HouseModel;
import com.powerup.propertymicroservice.domain.utils.constants.DomainConstants;
import com.powerup.propertymicroservice.domain.utils.constants.houses.HousesExceptionMessagesConstants;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static com.powerup.propertymicroservice.domain.utils.constants.houses.HouseConstants.*;
import static com.powerup.propertymicroservice.domain.utils.validations.ValidationUtils.isInvalidFormat;


public class HouseValidator {

    public void validate(HouseModel houseModel, LocalDate currentDate) {
        validateName(houseModel.getName());
        validateDescription(houseModel.getDescription());
        validateNumberOfRoomsAndBathrooms(houseModel.getNumberOfRooms(), houseModel.getNumberOfBathrooms());
        validatePrice(houseModel.getPrice());
        validateAddres(houseModel.getAddress());
        validatePublicationDate(houseModel.getActivePublicationDate(), currentDate);
    }

    private void validatePublicationDate(LocalDate activePublicationDate, LocalDate currentDate) {

        if (activePublicationDate.isBefore(currentDate)) {
            throw new InvalidPublicationDateExcepcion(HousesExceptionMessagesConstants.DATE_PAST_ERROR_MESSAGE);
        }

        long daysDifference = ChronoUnit.DAYS.between(currentDate, activePublicationDate);

        if (daysDifference > MAX_DAYS_FUTURE_PUBLICATION) {
            throw new InvalidPublicationDateExcepcion(
                    String.format(HousesExceptionMessagesConstants.DATE_FUTURE_LIMIT_MESSAGE, MAX_DAYS_FUTURE_PUBLICATION)
            );
        }
    }

    private void validateName(String name) {
        if (name == null) {
            throw new RequiredFieldNullOrEmptyException(DomainConstants.FIELD_NAME_NULL_MESSAGE);
        }
        String trimmedName = name.trim();
        if (trimmedName.isEmpty()) {
            throw new RequiredFieldNullOrEmptyException(DomainConstants.FIELD_NAME_EMPTY_MESSAGE);
        }
        if (trimmedName.length() > NAME_MAX_LENGTH) {
            throw new NameMaxSizeExceededException(
                    String.format(HousesExceptionMessagesConstants.MAX_LENGTH_MESSAGE, NAME_MAX_LENGTH)
            );
        }
        if (isInvalidFormat(trimmedName, STRING_ONLY_VALID_FORMAT_REGEX)) {
            throw new InvalidNameFormatException(
                    String.format(HousesExceptionMessagesConstants.INVALID_HOUSE_NAME_FORMAT_MESSAGE, trimmedName)
            );
        }
    }

    private void validateDescription(String description) {
        if (description == null) {
            throw new RequiredFieldNullOrEmptyException(DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        }

        String trimmedDescription = description.trim();
        if (trimmedDescription.isEmpty()) {
            throw new RequiredFieldNullOrEmptyException(DomainConstants.FIELD_DESCRIPTION_EMPTY_MESSAGE);
        }

        if (trimmedDescription.length() > DESCRIPTION_MAX_LENGTH) {
            throw new DescriptionMaxSizeExceededException(
                    String.format(HousesExceptionMessagesConstants.MAX_LENGTH_MESSAGE, DESCRIPTION_MAX_LENGTH)
            );
        }

        if (isInvalidFormat(trimmedDescription, STRING_ALPHANUMERIC_VALID_FORMAT_REGEX)) {
            throw new InvalidDescriptionFormatException(HousesExceptionMessagesConstants.INVALID_HOUSE_DESCRIPTION_FORMAT_MESSAGE);
        }
    }

    private void validateNumberOfRoomsAndBathrooms(Integer numberRooms, Integer numberBathrooms) {
        if (numberRooms != null && numberBathrooms != null) {

            if (numberRooms < 0 || numberBathrooms < 0) {
                throw new InvalidFormatExcepcion(HousesExceptionMessagesConstants.NEGATIVE_INT_ERROR_MESSAGE);
            }
        } else {
            throw new RequiredFieldNullOrEmptyException(HousesExceptionMessagesConstants.NOT_NULL_OR_EMPTY_ROOM_BATHROOM);
        }
    }
    
    private void validatePrice(BigDecimal price) {
        if (price == null) {
            throw new RequiredFieldNullOrEmptyException(HousesExceptionMessagesConstants.NOT_NULL_OR_EMPTY_PRICE);
        }
        
        if (price.compareTo(MIN_PRICE) < 0) {
            throw new InvalidFormatExcepcion(
                    String.format(HousesExceptionMessagesConstants.INVALID_MIN_PRICE, MIN_PRICE)
            );
        }
    }
    
    private void validateAddres(String address) {
        if (address == null) {
            throw new RequiredFieldNullOrEmptyException(HousesExceptionMessagesConstants.FIELD_ADDRES_NULL_MESSAGE);
        }
        
        String trimmedAddress = address.trim();
        if (trimmedAddress.isEmpty()) {
            throw new RequiredFieldNullOrEmptyException(HousesExceptionMessagesConstants.FIELD_ADDRES_EMPTY_MESSAGE);
        }
        
        if (isInvalidFormat(trimmedAddress, STRING_ALPHANUMERIC_ADDRESS_VALID_FORMAT_REGEX)) {
            throw new InvalidFormatExcepcion(
                    String.format(HousesExceptionMessagesConstants.INVALID_ADDRESS_FORMAT_MESSAGE, trimmedAddress)
            );
        }
    }
}
