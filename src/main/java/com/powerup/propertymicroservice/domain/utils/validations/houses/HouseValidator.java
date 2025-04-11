package com.powerup.propertymicroservice.domain.utils.validations.houses;

import com.powerup.propertymicroservice.domain.exceptions.InvalidPublicationDateExcepcion;
import com.powerup.propertymicroservice.domain.utils.constants.houses.HousesExceptionMessagesConstants;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static com.powerup.propertymicroservice.domain.utils.constants.houses.HouseConstants.MAX_DAYS_FUTURE_PUBLICATION;


public class HouseValidator {

    public void validatePublicationDate(LocalDate activePublicationDate, LocalDate currentDate) {

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
}
