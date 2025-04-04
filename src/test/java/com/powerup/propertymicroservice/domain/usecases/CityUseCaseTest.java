package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.domain.exceptions.ElementAmbiguousNameException;
import com.powerup.propertymicroservice.domain.exceptions.ElementNotFoundException;
import com.powerup.propertymicroservice.domain.model.CityModel;
import com.powerup.propertymicroservice.domain.model.DepartmentModel;
import com.powerup.propertymicroservice.domain.ports.out.CityPersistencePort;
import com.powerup.propertymicroservice.domain.utils.factories.city.CityModelFactoryForTest;
import com.powerup.propertymicroservice.domain.utils.factories.department.DepartmentModelFactoryForTest;
import com.powerup.propertymicroservice.domain.utils.validations.cities.CityValidator;
import com.powerup.propertymicroservice.domain.utils.validations.departments.DepartmentValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CityUseCaseTest {

    @Mock
    private CityPersistencePort cityPersistencePort;

    @Mock
    private CityValidator cityValidator;

    @Mock
    private DepartmentValidator departmentValidator;

    @InjectMocks
    private CityUseCase cityUseCase;

    @Test
    void getUniqueCityByName_shouldReturnCity_whenExactlyOneCityFound() {
        // Arrange
        String cityName = "Medellín";
        CityModel expectedCity = CityModelFactoryForTest.createExistingCityModel(1L, cityName, "Description", null);
        when(cityPersistencePort.getAllCitiesByName(cityName)).thenReturn(Collections.singletonList(expectedCity));

        // Act
        CityModel actualCity = cityUseCase.getUniqueCityByName(cityName);

        // Assert
        assertEquals(expectedCity, actualCity);
        verify(cityValidator, times(1)).validateCityName(cityName);
        verify(cityPersistencePort, times(1)).getAllCitiesByName(cityName);
    }

    @Test
    void getUniqueCityByName_shouldThrowElementAmbiguousNameException_whenMultipleCitiesFound() {
        // Arrange
        String cityName = "CommonCity";
        CityModel city1 = CityModelFactoryForTest.createExistingCityModel(1L, cityName, "Description 1", null);
        CityModel city2 = CityModelFactoryForTest.createExistingCityModel(2L, cityName, "Description 2", null);
        when(cityPersistencePort.getAllCitiesByName(cityName)).thenReturn(Arrays.asList(city1, city2));

        // Act & Assert
        assertThrows(ElementAmbiguousNameException.class, () -> cityUseCase.getUniqueCityByName(cityName));
        verify(cityValidator, times(1)).validateCityName(cityName);
        verify(cityPersistencePort, times(1)).getAllCitiesByName(cityName);
    }

    @Test
    void getUniqueCityByName_shouldThrowElementNotFoundException_whenNoCityFound() {
        // Arrange
        String cityName = "NonExistentCity";
        when(cityPersistencePort.getAllCitiesByName(cityName)).thenReturn(Collections.emptyList());

        // Act & Assert
        assertThrows(ElementNotFoundException.class, () -> cityUseCase.getUniqueCityByName(cityName));
        verify(cityValidator, times(1)).validateCityName(cityName);
        verify(cityPersistencePort, times(1)).getAllCitiesByName(cityName);
    }

    @Test
    void getCityByNameAndDepartmentName_shouldReturnCity_whenCityAndDepartmentFound() {
        // Arrange
        String cityName = "Medellín";
        String departmentName = "Antioquia";
        DepartmentModel antioquia = DepartmentModelFactoryForTest.createExistingDepartmentModel(1L, departmentName, "Description");
        CityModel expectedCity = CityModelFactoryForTest.createExistingCityModel(1L, cityName, "Description", antioquia);
        when(cityPersistencePort.getCityAndDepartmentByName(cityName, departmentName)).thenReturn(Optional.of(expectedCity));

        // Act
        CityModel actualCity = cityUseCase.getCityByNameAndDepartmentName(cityName, departmentName);

        // Assert
        assertEquals(expectedCity, actualCity);
        verify(cityValidator, times(1)).validateCityName(cityName);
        verify(departmentValidator, times(1)).validateDepartmentName(departmentName);
        verify(cityPersistencePort, times(1)).getCityAndDepartmentByName(cityName, departmentName);
    }

    @Test
    void getCityByNameAndDepartmentName_shouldThrowElementNotFoundException_whenCityNotFoundInDepartment() {
        // Arrange
        String cityName = "NonExistentCity";
        String departmentName = "Antioquia";
        when(cityPersistencePort.getCityAndDepartmentByName(cityName, departmentName)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ElementNotFoundException.class, () -> cityUseCase.getCityByNameAndDepartmentName(cityName, departmentName));
        verify(cityValidator, times(1)).validateCityName(cityName);
        verify(departmentValidator, times(1)).validateDepartmentName(departmentName);
        verify(cityPersistencePort, times(1)).getCityAndDepartmentByName(cityName, departmentName);
    }

}