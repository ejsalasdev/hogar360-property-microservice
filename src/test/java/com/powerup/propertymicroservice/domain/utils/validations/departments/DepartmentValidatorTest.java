package com.powerup.propertymicroservice.domain.utils.validations.departments;

import com.powerup.propertymicroservice.domain.exceptions.InvalidNameFormatException;
import com.powerup.propertymicroservice.domain.exceptions.NameMaxSizeExceededException;
import com.powerup.propertymicroservice.domain.exceptions.RequiredFieldNullOrEmptyException;
import com.powerup.propertymicroservice.domain.utils.constants.departments.DepartmentConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentValidatorTest {

    private DepartmentValidator validator;

    @BeforeEach
    void setUp() {
        validator = new DepartmentValidator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void validateDepartmentName_shouldThrowRequiredFieldNullOrEmptyException_whenNullOrEmpty(String invalidName) {
        assertThrows(RequiredFieldNullOrEmptyException.class, () -> validator.validateDepartmentName(invalidName));
    }

    @Test
    void validateDepartmentName_shouldThrowNameMaxSizeExceededException_whenExceedsMaxLength() {
        int maxLength = DepartmentConstants.NAME_MAX_LENGTH;
        String tooLongName = "A".repeat(maxLength + 1);
        assertThrows(NameMaxSizeExceededException.class, () -> validator.validateDepartmentName(tooLongName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Invalid!Format", "With Numbers 123", "With SpecialChars#$%"})
    void validateDepartmentName_shouldThrowInvalidNameFormatException_whenInvalidFormat(String invalidName) {
        assertThrows(InvalidNameFormatException.class, () -> validator.validateDepartmentName(invalidName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Antioquia", "Cundinamarca", "Valle del Cauca", "Atlántico", "Santander"})
    void validateDepartmentName_shouldNotThrowException_whenValidFormat(String validName) {
        assertDoesNotThrow(() -> validator.validateDepartmentName(validName));
    }

}