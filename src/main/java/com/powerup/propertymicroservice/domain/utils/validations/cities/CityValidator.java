package com.powerup.propertymicroservice.domain.utils.validations.cities;

import com.powerup.propertymicroservice.domain.exceptions.*;
import com.powerup.propertymicroservice.domain.model.CityModel;
import com.powerup.propertymicroservice.domain.model.DepartmentModel;
import com.powerup.propertymicroservice.domain.ports.out.CityPersistencePort;
import com.powerup.propertymicroservice.domain.ports.out.DepartmentPersistencePort;
import com.powerup.propertymicroservice.domain.utils.constants.CommonConstants;
import com.powerup.propertymicroservice.domain.utils.constants.cities.CitiesExceptionsMessagesConstants;
import com.powerup.propertymicroservice.domain.utils.constants.cities.CityConstants;
import com.powerup.propertymicroservice.domain.utils.constants.departments.DepartmentExceptionMessagesConstants;

import java.util.Optional;

import static com.powerup.propertymicroservice.domain.utils.validations.ValidationUtils.isInvalidFormat;
import static com.powerup.propertymicroservice.domain.utils.constants.CommonConstants.VALID_FORMAT_REGEX;

public class CityValidator {

    private final DepartmentPersistencePort departmentPersistencePort;
    private final CityPersistencePort cityPersistencePort;

    public CityValidator(DepartmentPersistencePort departmentPersistencePort, CityPersistencePort cityPersistencePort) {
        this.departmentPersistencePort = departmentPersistencePort;
        this.cityPersistencePort = cityPersistencePort;
    }

    public void validateCityCreation(CityModel cityModel, String departmentName) {
        validateCityName(cityModel.getName());
        validateCityDescription(cityModel.getDescription());
        DepartmentModel department = findDepartmentByName(departmentName);
        validateCityDoesNotExistInDepartment(cityModel.getName(), department.getId());
    }

    private void validateCityName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new RequiredFieldNullOrEmptyException(CommonConstants.FIELD_NAME_NULL_OR_EMPTY_MESSAGE);
        }
        String trimmedName = name.trim();
        if (trimmedName.length() > CityConstants.NAME_MAX_LENGTH) {
            throw new NameMaxSizeExceededException(CitiesExceptionsMessagesConstants.CITY_NAME_MAX_SIZE_MESSAGE);
        }
        if (isInvalidFormat(trimmedName, VALID_FORMAT_REGEX)) {
            throw new InvalidNameFormatException(String.format(CitiesExceptionsMessagesConstants.INVALID_CITY_NAME_FORMAT_MESSAGE,trimmedName));
        }
    }

    private void validateCityDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new RequiredFieldNullOrEmptyException(CommonConstants.FIELD_DESCRIPTION_NULL_OR_EMPTY_MESSAGE);
        }
        String trimmedDescription = description.trim();
        if (trimmedDescription.length() > CityConstants.DESCRIPTION_MAX_LENGTH) {
            throw new DescriptionMaxSizeExceededException(CitiesExceptionsMessagesConstants.CITY_DESCRIPTION_MAX_SIZE_MESSAGE);
        }
        if (isInvalidFormat(trimmedDescription, VALID_FORMAT_REGEX)) {
            throw new InvalidDescriptionFormatException(CitiesExceptionsMessagesConstants.INVALID_CITY_DESCRIPTION_FORMAT_MESSAGE);
        }
    }

    private DepartmentModel findDepartmentByName(String departmentName) {
        return departmentPersistencePort.getDepartmentByName(departmentName)
                .orElseThrow(() -> new ElementNotFoundException(DepartmentExceptionMessagesConstants.DEPARTMENT_NOT_FOUND_EXCEPTION + departmentName));
    }

    private void validateCityDoesNotExistInDepartment(String cityName, Long departmentId) {
        Optional<CityModel> existingCity = cityPersistencePort.getCityByNameAndDepartmentId(cityName, departmentId);
        if (existingCity.isPresent()) {
            throw new ElementAlreadyExistsException(String.format(CitiesExceptionsMessagesConstants.CITY_ALREADY_EXISTS_IN_DEPARTMENT_EXCEPTION, cityName));
        }
    }
}