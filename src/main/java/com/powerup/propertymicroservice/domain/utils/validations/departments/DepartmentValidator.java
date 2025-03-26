package com.powerup.propertymicroservice.domain.utils.validations.departments;

import com.powerup.propertymicroservice.domain.exceptions.*;
import com.powerup.propertymicroservice.domain.model.DepartmentModel;
import com.powerup.propertymicroservice.domain.utils.constants.CommonConstants;
import com.powerup.propertymicroservice.domain.utils.constants.departments.DepartmentConstants;
import com.powerup.propertymicroservice.domain.utils.constants.departments.DepartmentExceptionMessagesConstants;
import com.powerup.propertymicroservice.domain.utils.validations.ValidationUtils;

public class DepartmentValidator {
    public void validateDepartment(DepartmentModel departmentModel) {
        validateName(departmentModel.getName());
        validateDescription(departmentModel.getDescription());
    }

    public void validateName(String name) {
        if (name == null) {
            throw new RequiredFieldNullOrEmptyException(CommonConstants.FIELD_NAME_NULL_MESSAGE);
        }
        String trimmedName = name.trim();
        if (trimmedName.isEmpty()) {
            throw new RequiredFieldNullOrEmptyException(CommonConstants.FIELD_NAME_EMPTY_MESSAGE);
        }
        if (trimmedName.length() > DepartmentConstants.NAME_MAX_LENGTH) {
            throw new NameMaxSizeExceededException(DepartmentExceptionMessagesConstants.DEPARTMENT_NAME_MAX_SIZE_MESSAGE);
        }
        if (ValidationUtils.isInvalidFormat(trimmedName, CommonConstants.VALID_FORMAT_REGEX)) {
            throw new InvalidNameFormatException(DepartmentExceptionMessagesConstants.INVALID_DEPARTMENT_NAME_FORMAT_MESSAGE);
        }
    }

    public void validateDescription(String description) {
        if (description == null) {
            throw new RequiredFieldNullOrEmptyException(CommonConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        }
        String trimmedDescription = description.trim();
        if (trimmedDescription.isEmpty()) {
            throw new RequiredFieldNullOrEmptyException(CommonConstants.FIELD_DESCRIPTION_EMPTY_MESSAGE);
        }
        if (trimmedDescription.length() > DepartmentConstants.DESCRIPTION_MAX_LENGTH) {
            throw new NameMaxSizeExceededException(DepartmentExceptionMessagesConstants.DEPARTMENT_DESCRIPTION_MAX_SIZE_MESSAGE);
        }
        if (ValidationUtils.isInvalidFormat(trimmedDescription, CommonConstants.VALID_FORMAT_REGEX)) {
            throw new InvalidDescriptionFormatException(DepartmentExceptionMessagesConstants.INVALID_DEPARTMENT_DESCRIPTION_FORMAT_MESSAGE);
        }
    }
}
