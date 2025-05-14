package com.powerup.propertymicroservice.domain.usecases;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.powerup.propertymicroservice.domain.exceptions.ElementAmbiguousNameException;
import com.powerup.propertymicroservice.domain.exceptions.ElementNotFoundException;
import com.powerup.propertymicroservice.domain.model.CityModel;
import com.powerup.propertymicroservice.domain.ports.in.CityServicePort;
import com.powerup.propertymicroservice.domain.ports.out.CityPersistencePort;
import com.powerup.propertymicroservice.domain.utils.constants.cities.CitiesExceptionsMessagesConstants;
import com.powerup.propertymicroservice.domain.utils.validations.cities.CityValidator;
import com.powerup.propertymicroservice.domain.utils.validations.departments.DepartmentValidator;

public class CityUseCase implements CityServicePort {

    private final CityPersistencePort cityPersistencePort;
    private final CityValidator cityValidator;
    private final DepartmentValidator departmentValidator;

    public CityUseCase(CityPersistencePort cityPersistencePort, CityValidator cityValidator, DepartmentValidator departmentValidator) {
        this.cityPersistencePort = cityPersistencePort;
        this.cityValidator = cityValidator;
        this.departmentValidator = departmentValidator;
    }

    @Override
    public CityModel getUniqueCityByName(String cityName) {
        cityValidator.validateCityName(cityName);
        List<CityModel> cities = cityPersistencePort.getAllCitiesByName(cityName);
        if (cities.size() == 1) {
            return cities.get(0);
        } else if (cities.size() > 1) {
            throw new ElementAmbiguousNameException(
                    String.format(CitiesExceptionsMessagesConstants.CITY_AMBIGOUS_FOUND_EXCEPTION,
                    cities.size(), cityName
                    ));
        } else {
            throw new ElementNotFoundException(
                    String.format(CitiesExceptionsMessagesConstants.CITY_NOT_FOUND_EXCEPTION,
                            cityName
                    ));
        }
    }

    @Override
    public CityModel getCityByNameAndDepartmentName(String cityName, String departmentName) {
        cityValidator.validateCityName(cityName);
        departmentValidator.validateDepartmentName(departmentName);
        Optional<CityModel> city = cityPersistencePort.getCityAndDepartmentByName(cityName, departmentName);
        if (city.isEmpty()) {
            throw new ElementNotFoundException(String.format(CitiesExceptionsMessagesConstants.CITY_NOT_FOUND_IN_DEPARTMENT_EXCEPTION, cityName, departmentName));
        }
        return city.get();
    }

    @Override
    public List<CityModel> getAllCitiesByDepartmentId(Long departmentId, boolean orderAsc) {
        List<CityModel> cities = cityPersistencePort.findAllByDepartmentId(departmentId);
        
        Comparator<CityModel> comparator = Comparator.comparing(CityModel::getName);
        
        if (!orderAsc) {
            comparator = comparator.reversed();
        }
        
        return cities.stream()
                .sorted(comparator)
                .toList();
    }
}
