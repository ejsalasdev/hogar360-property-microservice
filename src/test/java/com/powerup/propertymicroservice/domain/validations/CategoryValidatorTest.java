package com.powerup.propertymicroservice.domain.validations;

import com.powerup.propertymicroservice.domain.exceptions.DescriptionMaxSizeExceededException;
import com.powerup.propertymicroservice.domain.exceptions.InvalidCategoryNameFormatException;
import com.powerup.propertymicroservice.domain.exceptions.NameMaxSizeExceededException;
import com.powerup.propertymicroservice.domain.exceptions.RequiredFieldNullOrEmptyException;
import com.powerup.propertymicroservice.domain.utils.constants.CategoryValidationConstants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CategoryValidatorTest {
    
    @InjectMocks
    private CategoryValidator categoryValidator;

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   "}) // Spaces only
    void Expect_RequiredFieldNullOrEmptyException_When_NameIsNullOrEmpty(String name) {
        // Arrange & Act & Assert
        assertThrows(RequiredFieldNullOrEmptyException.class, () -> categoryValidator.validateName(name));
    }

    @Test
    void Expect_NameMaxSizeExceededException_When_NameExceedsMaxLength() {
        // Arrange
        String longName = "a".repeat(CategoryValidationConstants.NAME_MAX_LENGTH + 1);

        // Act & Assert
        assertThrows(NameMaxSizeExceededException.class, () -> categoryValidator.validateName(longName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Invalid Name!", " Invalid Name. "})
    void Expect_InvalidCategoryNameFormatException_When_NameHasInvalidFormat(String name) {
        // Arrange & Act & Assert
        assertThrows(InvalidCategoryNameFormatException.class, () -> categoryValidator.validateName(name));
    }

    @Test
    void When_ValidName_Expect_NoExceptionThrown() {
        // Arrange
        String validName = "ValidName";

        // Act & Assert
        assertDoesNotThrow(() -> categoryValidator.validateName(validName));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   "}) // Spaces only
    void Expect_RequiredFieldNullOrEmptyException_When_DescriptionIsNullOrEmpty(String description) {
        // Arrange & Act & Assert
        assertThrows(RequiredFieldNullOrEmptyException.class, () -> categoryValidator.validateDescription(description));
    }

    @Test
    void Expect_DescriptionMaxSizeExceededException_When_DescriptionExceedsMaxLength() {
        // Arrange
        String longDescription = "a".repeat(CategoryValidationConstants.DESCRIPTION_MAX_LENGTH + 1);

        // Act & Assert
        assertThrows(DescriptionMaxSizeExceededException.class, () -> categoryValidator.validateDescription(longDescription));
    }

    @Test
    void When_ValidDescription_Expect_NoExceptionThrown() {
        // Arrange
        String validDescription = "Valid Description";

        // Act & Assert
        assertDoesNotThrow(() -> categoryValidator.validateDescription(validDescription));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Invalid Description!", " Invalid Description. "})
    void Expect_InvalidCategoryDescriptionFormatException_When_DescriptionHasInvalidFormat(String description) {
        // Arrange & Act & Assert
        assertThrows(InvalidCategoryNameFormatException.class, () -> categoryValidator.validateName(description));
    }
}