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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
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

    private DepartmentModel department1;
    private DepartmentModel department2;
    private CityModel city1;
    private CityModel city2;
    private CityModel city3;

    @BeforeEach
    void setUp() {
        department1 = DepartmentModelFactoryForTest.createExistingDepartmentModel(1L, "Antioquia", "Departamento de Antioquia");
        department2 = DepartmentModelFactoryForTest.createExistingDepartmentModel(2L, "Cundinamarca", "Departamento de Cundinamarca");

        city1 = CityModelFactoryForTest.createExistingCityModel(1L, "Medellín", "Ciudad de Medellín", department1);
        city2 = CityModelFactoryForTest.createExistingCityModel(2L, "Bogotá", "Ciudad de Bogotá", department2);
        city3 = CityModelFactoryForTest.createExistingCityModel(3L, "Medellín", "Ciudad de Medellín", department2);
    }

    @Test
    void getUniqueCityByName_WhenCityExists_ShouldReturnCity() {
        // Arrange
        when(cityPersistencePort.getAllCitiesByName("Bogotá"))
                .thenReturn(List.of(city2));

        // Act
        CityModel result = cityUseCase.getUniqueCityByName("Bogotá");

        // Assert
        assertNotNull(result);
        assertEquals("Bogotá", result.getName());
        verify(cityValidator).validateCityName("Bogotá");
        verify(cityPersistencePort).getAllCitiesByName("Bogotá");
    }

    @Test
    void getUniqueCityByName_WhenMultipleCitiesExist_ShouldThrowException() {
        // Arrange
        when(cityPersistencePort.getAllCitiesByName("Medellín"))
                .thenReturn(Arrays.asList(city1, city3));

        // Act & Assert
        assertThrows(ElementAmbiguousNameException.class, () -> 
            cityUseCase.getUniqueCityByName("Medellín")
        );
        verify(cityValidator).validateCityName("Medellín");
        verify(cityPersistencePort).getAllCitiesByName("Medellín");
    }

    @Test
    void getUniqueCityByName_WhenCityDoesNotExist_ShouldThrowException() {
        // Arrange
        when(cityPersistencePort.getAllCitiesByName("Inexistente"))
                .thenReturn(List.of());

        // Act & Assert
        assertThrows(ElementNotFoundException.class, () -> 
            cityUseCase.getUniqueCityByName("Inexistente")
        );
        verify(cityValidator).validateCityName("Inexistente");
        verify(cityPersistencePort).getAllCitiesByName("Inexistente");
    }

    @Test
    void getCityByNameAndDepartmentName_WhenCityExists_ShouldReturnCity() {
        // Arrange
        when(cityPersistencePort.getCityAndDepartmentByName("Medellín", "Antioquia"))
                .thenReturn(Optional.of(city1));

        // Act
        CityModel result = cityUseCase.getCityByNameAndDepartmentName("Medellín", "Antioquia");

        // Assert
        assertNotNull(result);
        assertEquals("Medellín", result.getName());
        assertEquals("Antioquia", result.getDepartmentModel().getName());
        verify(cityValidator).validateCityName("Medellín");
        verify(departmentValidator).validateDepartmentName("Antioquia");
        verify(cityPersistencePort).getCityAndDepartmentByName("Medellín", "Antioquia");
    }

    @Test
    void getCityByNameAndDepartmentName_WhenCityDoesNotExist_ShouldThrowException() {
        // Arrange
        when(cityPersistencePort.getCityAndDepartmentByName("Inexistente", "Antioquia"))
                .thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ElementNotFoundException.class, () -> 
            cityUseCase.getCityByNameAndDepartmentName("Inexistente", "Antioquia")
        );
        verify(cityValidator).validateCityName("Inexistente");
        verify(departmentValidator).validateDepartmentName("Antioquia");
        verify(cityPersistencePort).getCityAndDepartmentByName("Inexistente", "Antioquia");
    }

    @Test
    void getAllCities_WhenOrderAsc_ShouldReturnOrderedList() {
        // Arrange
        List<CityModel> cities = Arrays.asList(city2, city1, city3);
        when(cityPersistencePort.findAll()).thenReturn(cities);

        // Act
        List<CityModel> result = cityUseCase.getAllCities(true);

        // Assert
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("Bogotá", result.get(0).getName());
        assertEquals("Medellín", result.get(1).getName());
        assertEquals("Medellín", result.get(2).getName());
        verify(cityPersistencePort).findAll();
    }

    @Test
    void getAllCities_WhenOrderDesc_ShouldReturnReversedList() {
        // Arrange
        List<CityModel> cities = Arrays.asList(city1, city2, city3);
        when(cityPersistencePort.findAll()).thenReturn(cities);

        // Act
        List<CityModel> result = cityUseCase.getAllCities(false);

        // Assert
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("Medellín", result.get(0).getName());
        assertEquals("Medellín", result.get(1).getName());
        assertEquals("Bogotá", result.get(2).getName());
        verify(cityPersistencePort).findAll();
    }
}