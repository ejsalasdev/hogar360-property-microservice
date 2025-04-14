package com.powerup.propertymicroservice.domain.utils.validations.houses;

import com.powerup.propertymicroservice.domain.exceptions.*;
import com.powerup.propertymicroservice.domain.model.HouseModel;
import com.powerup.propertymicroservice.domain.utils.constants.houses.HouseConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HouseValidatorTest {

    private HouseValidator houseValidator;
    private HouseModel houseModel;
    private LocalDate currentDate;

    @BeforeEach
    void setUp() {
        houseValidator = new HouseValidator();
        currentDate = LocalDate.now();
        houseModel = new HouseModel();
        houseModel.setName("Casa de Prueba");
        houseModel.setDescription("Descripción de prueba");
        houseModel.setNumberOfRooms(3);
        houseModel.setNumberOfBathrooms(2);
        houseModel.setPrice(BigDecimal.valueOf(100000));
        houseModel.setAddress("Calle Falsa 123");
        houseModel.setActivePublicationDate(currentDate.plusDays(1));
    }

    @Test
    void validate_validHouse_doesNotThrowException() {
        assertDoesNotThrow(() -> houseValidator.validate(houseModel, currentDate));
    }

    // Tests para validateName
    @Test
    void validateName_nullName_throwsRequiredFieldNullOrEmptyException() {
        houseModel.setName(null);
        assertThrows(RequiredFieldNullOrEmptyException.class, () -> houseValidator.validate(houseModel, currentDate));
    }

    @Test
    void validateName_emptyName_throwsRequiredFieldNullOrEmptyException() {
        houseModel.setName("   ");
        assertThrows(RequiredFieldNullOrEmptyException.class, () -> houseValidator.validate(houseModel, currentDate));
    }

    @Test
    void validateName_nameExceedsMaxLength_throwsNameMaxSizeExceededException() {
        houseModel.setName("a".repeat((int) (HouseConstants.NAME_MAX_LENGTH + 1)));
        assertThrows(NameMaxSizeExceededException.class, () -> houseValidator.validate(houseModel, currentDate));
    }

    @Test
    void validateName_invalidFormatName_throwsInvalidNameFormatException() {
        houseModel.setName("Casa 123!");
        assertThrows(InvalidNameFormatException.class, () -> houseValidator.validate(houseModel, currentDate));
    }

    @Test
    void validateName_validName_doesNotThrowException() {
        houseModel.setName("Casa Bonita");
        assertDoesNotThrow(() -> houseValidator.validate(houseModel, currentDate));
    }

    // Tests para validateDescription
    @Test
    void validateDescription_nullDescription_throwsRequiredFieldNullOrEmptyException() {
        houseModel.setDescription(null);
        assertThrows(RequiredFieldNullOrEmptyException.class, () -> houseValidator.validate(houseModel, currentDate));
    }

    @Test
    void validateDescription_emptyDescription_throwsRequiredFieldNullOrEmptyException() {
        houseModel.setDescription("   ");
        assertThrows(RequiredFieldNullOrEmptyException.class, () -> houseValidator.validate(houseModel, currentDate));
    }

    @Test
    void validateDescription_descriptionExceedsMaxLength_throwsDescriptionMaxSizeExceededException() {
        houseModel.setDescription("a".repeat((int) (HouseConstants.DESCRIPTION_MAX_LENGTH + 1)));
        assertThrows(DescriptionMaxSizeExceededException.class, () -> houseValidator.validate(houseModel, currentDate));
    }

    @Test
    void validateDescription_invalidFormatDescription_throwsInvalidDescriptionFormatException() {
        houseModel.setDescription("Descripción con !@#");
        assertThrows(InvalidDescriptionFormatException.class, () -> houseValidator.validate(houseModel, currentDate));
    }

    @Test
    void validateDescription_validDescription_doesNotThrowException() {
        houseModel.setDescription("Amplia casa familiar");
        assertDoesNotThrow(() -> houseValidator.validate(houseModel, currentDate));
    }

    // Tests para validateNumberOfRoomsAndBathrooms
    @Test
    void validateNumberOfRoomsAndBathrooms_nullRooms_throwsRequiredFieldNullOrEmptyException() {
        houseModel.setNumberOfRooms(null);
        assertThrows(RequiredFieldNullOrEmptyException.class, () -> houseValidator.validate(houseModel, currentDate));
    }

    @Test
    void validateNumberOfRoomsAndBathrooms_nullBathrooms_throwsRequiredFieldNullOrEmptyException() {
        houseModel.setNumberOfBathrooms(null);
        assertThrows(RequiredFieldNullOrEmptyException.class, () -> houseValidator.validate(houseModel, currentDate));
    }

    @Test
    void validateNumberOfRoomsAndBathrooms_negativeRooms_throwsInvalidFormatExcepcion() {
        houseModel.setNumberOfRooms(-1);
        assertThrows(InvalidFormatExcepcion.class, () -> houseValidator.validate(houseModel, currentDate));
    }

    @Test
    void validateNumberOfRoomsAndBathrooms_negativeBathrooms_throwsInvalidFormatExcepcion() {
        houseModel.setNumberOfBathrooms(-1);
        assertThrows(InvalidFormatExcepcion.class, () -> houseValidator.validate(houseModel, currentDate));
    }

    @Test
    void validateNumberOfRoomsAndBathrooms_validNumbers_doesNotThrowException() {
        assertDoesNotThrow(() -> houseValidator.validate(houseModel, currentDate));
    }

    // Tests para validatePrice
    @Test
    void validatePrice_nullPrice_throwsRequiredFieldNullOrEmptyException() {
        houseModel.setPrice(null);
        assertThrows(RequiredFieldNullOrEmptyException.class, () -> houseValidator.validate(houseModel, currentDate));
    }

    @Test
    void validatePrice_priceBelowMin_throwsInvalidFormatExcepcion() {
        houseModel.setPrice(HouseConstants.MIN_PRICE.subtract(BigDecimal.ONE));
        assertThrows(InvalidFormatExcepcion.class, () -> houseValidator.validate(houseModel, currentDate));
    }

    @Test
    void validatePrice_validPrice_doesNotThrowException() {
        assertDoesNotThrow(() -> houseValidator.validate(houseModel, currentDate));
    }

    // Tests para validateAddres
    @Test
    void validateAddres_nullAddress_throwsRequiredFieldNullOrEmptyException() {
        houseModel.setAddress(null);
        assertThrows(RequiredFieldNullOrEmptyException.class, () -> houseValidator.validate(houseModel, currentDate));
    }

    @Test
    void validateAddres_emptyAddress_throwsRequiredFieldNullOrEmptyException() {
        houseModel.setAddress("   ");
        assertThrows(RequiredFieldNullOrEmptyException.class, () -> houseValidator.validate(houseModel, currentDate));
    }

    @Test
    void validateAddres_invalidFormatAddress_throwsInvalidFormatExcepcion() {
        houseModel.setAddress("Calle !@#");
        assertThrows(InvalidFormatExcepcion.class, () -> houseValidator.validate(houseModel, currentDate));
    }

    @Test
    void validateAddres_validAddress_doesNotThrowException() {
        houseModel.setAddress("Avenida Principal 456");
        assertDoesNotThrow(() -> houseValidator.validate(houseModel, currentDate));
    }

    // Tests para validatePublicationDate
    @Test
    void validatePublicationDate_activeDateBeforeCurrentDate_throwsInvalidPublicationDateExcepcion() {
        houseModel.setActivePublicationDate(currentDate.minusDays(1));
        assertThrows(InvalidPublicationDateExcepcion.class, () -> houseValidator.validate(houseModel, currentDate));
    }

    @Test
    void validatePublicationDate_activeDateTooFarInFuture_throwsInvalidPublicationDateExcepcion() {
        houseModel.setActivePublicationDate(currentDate.plusDays(HouseConstants.MAX_DAYS_FUTURE_PUBLICATION + 1));
        assertThrows(InvalidPublicationDateExcepcion.class, () -> houseValidator.validate(houseModel, currentDate));
    }

    @Test
    void validatePublicationDate_validActiveDate_doesNotThrowException() {
        assertDoesNotThrow(() -> houseValidator.validate(houseModel, currentDate));
        houseModel.setActivePublicationDate(currentDate);
        assertDoesNotThrow(() -> houseValidator.validate(houseModel, currentDate));
        houseModel.setActivePublicationDate(currentDate.plusDays(HouseConstants.MAX_DAYS_FUTURE_PUBLICATION));
        assertDoesNotThrow(() -> houseValidator.validate(houseModel, currentDate));
    }
}