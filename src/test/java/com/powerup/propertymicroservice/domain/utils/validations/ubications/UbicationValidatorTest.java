package com.powerup.propertymicroservice.domain.utils.validations.ubications;

import com.powerup.propertymicroservice.domain.exceptions.InvalidNameFormatException;
import com.powerup.propertymicroservice.domain.exceptions.NameMaxSizeExceededException;
import com.powerup.propertymicroservice.domain.exceptions.RequiredFieldNullOrEmptyException;
import com.powerup.propertymicroservice.domain.utils.constants.ubications.UbicationConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UbicationValidatorTest {

    private UbicationValidator validator;

    @BeforeEach
    void setUp() {
        validator = new UbicationValidator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void validateSectorName_shouldThrowRequiredFieldNullOrEmptyException_whenNullOrEmpty(String invalidSector) {
        assertThrows(RequiredFieldNullOrEmptyException.class, () -> validator.validateSectorName(invalidSector));
    }

    @Test
    void validateSectorName_shouldThrowNameMaxSizeExceededException_whenExceedsMaxLength() {
        int maxLength = UbicationConstants.NAME_MAX_LENGTH;
        String tooLongName = "A".repeat(maxLength + 1);
        assertThrows(NameMaxSizeExceededException.class, () -> validator.validateSectorName(tooLongName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Invalid!Format", "With Numbers 123", "With SpecialChars#$%"})
    void validateSectorName_shouldThrowInvalidNameFormatException_whenInvalidFormat(String invalidSector) {
        assertThrows(InvalidNameFormatException.class, () -> validator.validateSectorName(invalidSector));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Valid Name", "Another Valid Name", "With Spaces Between Words"})
    void validateSectorName_shouldNotThrowException_whenValidFormat(String validSector) {
        assertDoesNotThrow(() -> validator.validateSectorName(validSector));
    }

}