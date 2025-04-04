package com.powerup.propertymicroservice.domain.utils.validations.pagination;

import com.powerup.propertymicroservice.domain.exceptions.InvalidPageNumberException;
import com.powerup.propertymicroservice.domain.exceptions.InvalidPageSizeException;
import com.powerup.propertymicroservice.domain.exceptions.RequiredFieldNullOrEmptyException;
import com.powerup.propertymicroservice.domain.utils.constants.pagination.PaginationConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PaginationValidatorTest {

    private PaginationValidator validator;

    @BeforeEach
    void setUp() {
        validator = new PaginationValidator();
    }

    // Tests for validatePage method
    @Test
    void validatePage_shouldThrowRequiredFieldNullOrEmptyException_whenPageIsNull() {
        assertThrows(RequiredFieldNullOrEmptyException.class, () -> validator.validatePage(null));
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -1})
    void validatePage_shouldThrowInvalidPageNumberException_whenPageIsLessThanMin(int invalidPage) {
        assertThrows(InvalidPageNumberException.class, () -> validator.validatePage(invalidPage));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 100})
    void validatePage_shouldNotThrowException_whenPageIsValid(int validPage) {
        assertDoesNotThrow(() -> validator.validatePage(validPage));
    }

    // Tests for validateSize method
    @Test
    void validateSize_shouldThrowRequiredFieldNullOrEmptyException_whenSizeIsNull() {
        assertThrows(RequiredFieldNullOrEmptyException.class, () -> validator.validateSize(null));
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, 0})
    void validateSize_shouldThrowInvalidPageSizeException_whenSizeIsLessThanMin(int invalidSize) {
        assertThrows(InvalidPageSizeException.class, () -> validator.validateSize(invalidSize));
    }

    @ParameterizedTest
    @ValueSource(ints = {PaginationConstants.MAX_PAGE_SIZE + 1, PaginationConstants.MAX_PAGE_SIZE + 10})
    void validateSize_shouldThrowInvalidPageSizeException_whenSizeIsGreaterThanMax(int invalidSize) {
        assertThrows(InvalidPageSizeException.class, () -> validator.validateSize(invalidSize));
    }

    @ParameterizedTest
    @ValueSource(ints = {PaginationConstants.MIN_PAGE_SIZE, 10, PaginationConstants.MAX_PAGE_SIZE})
    void validateSize_shouldNotThrowException_whenSizeIsValid(int validSize) {
        assertDoesNotThrow(() -> validator.validateSize(validSize));
    }

}