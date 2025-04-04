package com.powerup.propertymicroservice.domain.utils.validations.categories;

import com.powerup.propertymicroservice.domain.exceptions.DescriptionMaxSizeExceededException;
import com.powerup.propertymicroservice.domain.exceptions.InvalidNameFormatException;
import com.powerup.propertymicroservice.domain.exceptions.NameMaxSizeExceededException;
import com.powerup.propertymicroservice.domain.exceptions.RequiredFieldNullOrEmptyException;
import com.powerup.propertymicroservice.domain.utils.constants.categories.CategoryConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CategoryValidatorTest {
    
    private CategoryValidator validator;
    
    @BeforeEach
    void setUp() {
        validator = new CategoryValidator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   "})
    void Expect_RequiredFieldNullOrEmptyException_When_NameIsNullOrEmpty(String name) {
        // Arrange & Act & Assert
        assertThrows(RequiredFieldNullOrEmptyException.class, () -> validator.validateName(name));
    }

    @Test
    void Expect_NameMaxSizeExceededException_When_NameExceedsMaxLength() {
        // Arrange
        String longName = "a".repeat(CategoryConstants.NAME_MAX_LENGTH + 1);

        // Act & Assert
        assertThrows(NameMaxSizeExceededException.class, () -> validator.validateName(longName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Invalid Name!", " Invalid Name. "})
    void Expect_InvalidCategoryNameFormatException_When_NameHasInvalidFormat(String name) {
        // Arrange & Act & Assert
        assertThrows(InvalidNameFormatException.class, () -> validator.validateName(name));
    }

    @Test
    void When_ValidName_Expect_NoExceptionThrown() {
        // Arrange
        String validName = "ValidName";

        // Act & Assert
        assertDoesNotThrow(() -> validator.validateName(validName));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   "})
    void Expect_RequiredFieldNullOrEmptyException_When_DescriptionIsNullOrEmpty(String description) {
        // Arrange & Act & Assert
        assertThrows(RequiredFieldNullOrEmptyException.class, () -> validator.validateDescription(description));
    }

    @Test
    void Expect_DescriptionMaxSizeExceededException_When_DescriptionExceedsMaxLength() {
        // Arrange
        String longDescription = "a".repeat(CategoryConstants.DESCRIPTION_MAX_LENGTH + 1);

        // Act & Assert
        assertThrows(DescriptionMaxSizeExceededException.class, () -> validator.validateDescription(longDescription));
    }

    @Test
    void When_ValidDescription_Expect_NoExceptionThrown() {
        // Arrange
        String validDescription = "Valid Description";

        // Act & Assert
        assertDoesNotThrow(() -> validator.validateDescription(validDescription));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Invalid Description!", " Invalid Description. "})
    void Expect_InvalidCategoryDescriptionFormatException_When_DescriptionHasInvalidFormat(String description) {
        // Arrange & Act & Assert
        assertThrows(InvalidNameFormatException.class, () -> validator.validateName(description));
    }
}