package com.powerup.propertymicroservice.domain.utils.validations.cities;

import com.powerup.propertymicroservice.domain.exceptions.InvalidNameFormatException;
import com.powerup.propertymicroservice.domain.exceptions.NameMaxSizeExceededException;
import com.powerup.propertymicroservice.domain.exceptions.RequiredFieldNullOrEmptyException;
import com.powerup.propertymicroservice.domain.utils.constants.cities.CityConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CityValidatorTest {

    private CityValidator validator;

    @BeforeEach
    void setUp() {
        validator = new CityValidator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void validateCityName_shouldThrowRequiredFieldNullOrEmptyException_whenNullOrEmpty(String invalidName) {
        assertThrows(RequiredFieldNullOrEmptyException.class, () -> validator.validateCityName(invalidName));
    }

    @Test
    void validateCityName_shouldThrowNameMaxSizeExceededException_whenExceedsMaxLength() {
        int maxLength = CityConstants.NAME_MAX_LENGTH;
        String tooLongName = "A".repeat(maxLength + 1);
        assertThrows(NameMaxSizeExceededException.class, () -> validator.validateCityName(tooLongName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Invalid!Format", "With Numbers 123", "With SpecialChars#$%"})
    void validateCityName_shouldThrowInvalidNameFormatException_whenInvalidFormat(String invalidName) {
        assertThrows(InvalidNameFormatException.class, () -> validator.validateCityName(invalidName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Medellín", "Bogotá", "Cali", "Barranquilla", "Pereira"})
    void validateCityName_shouldNotThrowException_whenValidFormat(String validName) {
        assertDoesNotThrow(() -> validator.validateCityName(validName));
    }

}