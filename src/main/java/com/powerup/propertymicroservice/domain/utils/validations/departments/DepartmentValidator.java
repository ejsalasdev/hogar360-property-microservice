package com.powerup.propertymicroservice.domain.utils.validations.departments;

import com.powerup.propertymicroservice.domain.exceptions.*;
import com.powerup.propertymicroservice.domain.model.DepartmentModel;
import com.powerup.propertymicroservice.domain.utils.constants.CommonConstants;
import com.powerup.propertymicroservice.domain.utils.constants.departments.DepartmentConstants;
import com.powerup.propertymicroservice.domain.utils.constants.departments.DepartmentsExceptionsMessagesConstants;
import com.powerup.propertymicroservice.domain.utils.validations.ValidationUtils;

public class DepartmentValidator {

    public void validateDepartmentName(String name) {
        if (name == null) {
            throw new RequiredFieldNullOrEmptyException(CommonConstants.FIELD_NAME_NULL_MESSAGE);
        }
        String trimmedName = name.trim();
        if (trimmedName.isEmpty()) {
            throw new RequiredFieldNullOrEmptyException(CommonConstants.FIELD_NAME_EMPTY_MESSAGE);
        }
        if (trimmedName.length() > DepartmentConstants.NAME_MAX_LENGTH) {
            throw new NameMaxSizeExceededException(DepartmentsExceptionsMessagesConstants.DEPARTMENT_NAME_MAX_SIZE_MESSAGE);
        }
        if (ValidationUtils.isInvalidFormat(trimmedName, CommonConstants.VALID_FORMAT_REGEX)) {
            throw new InvalidNameFormatException(DepartmentsExceptionsMessagesConstants.INVALID_DEPARTMENT_NAME_FORMAT_MESSAGE);
        }
    }
}
