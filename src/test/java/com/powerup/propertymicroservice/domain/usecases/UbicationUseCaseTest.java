package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.domain.exceptions.ElementAlreadyExistsException;
import com.powerup.propertymicroservice.domain.exceptions.ElementAmbiguousNameException;
import com.powerup.propertymicroservice.domain.exceptions.ElementNotFoundException;
import com.powerup.propertymicroservice.domain.model.CityModel;
import com.powerup.propertymicroservice.domain.model.DepartmentModel;
import com.powerup.propertymicroservice.domain.model.UbicationModel;
import com.powerup.propertymicroservice.domain.ports.in.CityServicePort;
import com.powerup.propertymicroservice.domain.ports.out.UbicationPersistencePort;
import com.powerup.propertymicroservice.domain.utils.factories.city.CityModelFactoryForTest;
import com.powerup.propertymicroservice.domain.utils.factories.ubication.UbicationModelFactoryForTest;
import com.powerup.propertymicroservice.domain.utils.factories.ubication.UbicationModelPaginationFactoryForTest;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;
import com.powerup.propertymicroservice.domain.utils.validations.pagination.PaginationValidator;
import com.powerup.propertymicroservice.domain.utils.validations.ubications.UbicationValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UbicationUseCaseTest {

    @Mock
    private UbicationPersistencePort ubicationPersistencePort;

    @Mock
    private CityServicePort cityServicePort;

    @Mock
    private UbicationValidator ubicationValidator;
    
    @Mock
    private PaginationValidator paginationValidator;

    @InjectMocks
    private UbicationUseCase ubicationUseCase;

    @Test
    void save_shouldSaveUbication_whenCityExistsAndDepartmentNameNotProvided() {
        // Arrange
        DepartmentModel antioquia = new DepartmentModel(1L, "Antioquia", "Departamento de Colombia");
        CityModel city = CityModelFactoryForTest.createExistingCityModel(1L, "Medellín", "Ciudad de la eterna primavera", antioquia);
        UbicationModel newUbication = UbicationModelFactoryForTest.createUbicationModelWithNewUbication(city);
        when(cityServicePort.getUniqueCityByName("Medellín")).thenReturn(city);
        when(ubicationPersistencePort.getUbicationBySectorAndCityId("SimpleSector", 1L)).thenReturn(Optional.empty());
        doNothing().when(ubicationPersistencePort).save(newUbication);

        // Act
        ubicationUseCase.save(newUbication, "Medellín", null);

        // Assert
        verify(ubicationValidator, times(1)).validateSectorName("SimpleSector");
        verify(cityServicePort, times(1)).getUniqueCityByName("Medellín");
        verify(ubicationPersistencePort, times(1)).getUbicationBySectorAndCityId("SimpleSector", 1L);
        verify(ubicationPersistencePort, times(1)).save(newUbication);
    }

    @Test
    void save_shouldSaveUbication_whenCityAndDepartmentNameProvidedAndExist() {
        // Arrange
        DepartmentModel antioquia = new DepartmentModel(1L, "Antioquia", "Departamento de Colombia");
        CityModel city = CityModelFactoryForTest.createExistingCityModel(1L, "Medellín", "Ciudad de la eterna primavera", antioquia);
        UbicationModel newUbication = UbicationModelFactoryForTest.createUbicationModelWithNewUbication(city);
        when(cityServicePort.getCityByNameAndDepartmentName("Medellín", "Antioquia")).thenReturn(city);
        when(ubicationPersistencePort.getUbicationBySectorAndCityId("SimpleSector", 1L)).thenReturn(Optional.empty());
        doNothing().when(ubicationPersistencePort).save(newUbication);

        // Act
        ubicationUseCase.save(newUbication, "Medellín", "Antioquia");

        // Assert
        verify(ubicationValidator, times(1)).validateSectorName("SimpleSector");
        verify(cityServicePort, times(1)).getCityByNameAndDepartmentName("Medellín", "Antioquia");
        verify(ubicationPersistencePort, times(1)).getUbicationBySectorAndCityId("SimpleSector", 1L);
        verify(ubicationPersistencePort, times(1)).save(newUbication);
    }

    @Test
    void save_shouldThrowElementAlreadyExistsException_whenUbicationWithSameSectorAndCityExists() {
        // Arrange
        DepartmentModel antioquia = new DepartmentModel(1L, "Antioquia", "Departamento de Colombia");
        CityModel city = CityModelFactoryForTest.createExistingCityModel(1L, "Medellín", "Ciudad de la eterna primavera", antioquia);
        UbicationModel existingUbication = UbicationModelFactoryForTest.createExistingUbicationModel(1L, "SimpleSector", city);
        UbicationModel newUbication = UbicationModelFactoryForTest.createUbicationModelWithNewUbication(city);
        when(cityServicePort.getUniqueCityByName("Medellín")).thenReturn(city);
        when(ubicationPersistencePort.getUbicationBySectorAndCityId("SimpleSector", 1L)).thenReturn(Optional.of(existingUbication));

        // Act & Assert
        assertThrows(ElementAlreadyExistsException.class, () -> ubicationUseCase.save(newUbication, "Medellín", null));

        verify(ubicationValidator, times(1)).validateSectorName("SimpleSector");
        verify(cityServicePort, times(1)).getUniqueCityByName("Medellín");
        verify(ubicationPersistencePort, times(1)).getUbicationBySectorAndCityId("SimpleSector", 1L);
        verify(ubicationPersistencePort, never()).save(any());
    }

    @Test
    void save_shouldThrowElementNotFoundException_whenCityDoesNotExistAndDepartmentNameNotProvided() {
        // Arrange
        UbicationModel newUbication = UbicationModelFactoryForTest.createUbicationModelWithNewUbication(null);
        when(cityServicePort.getUniqueCityByName("NonExistentCity"))
                .thenThrow(new ElementNotFoundException("-CityUseCase- No se encontró ninguna ciudad con el nombre 'NonExistentCity'."));

        // Act & Assert
        assertThrows(ElementNotFoundException.class, () -> ubicationUseCase.save(newUbication, "NonExistentCity", null));

        verify(ubicationValidator, times(1)).validateSectorName("SimpleSector");
        verify(cityServicePort, times(1)).getUniqueCityByName("NonExistentCity");
        verify(cityServicePort, never()).getCityByNameAndDepartmentName(any(), any());
        verify(ubicationPersistencePort, never()).getUbicationBySectorAndCityId(any(), any());
        verify(ubicationPersistencePort, never()).save(any());
    }

    @Test
    void save_shouldThrowElementNotFoundException_whenCityDoesNotExistWithDepartmentNameProvided() {
        // Arrange
        UbicationModel newUbication = UbicationModelFactoryForTest.createUbicationModelWithNewUbication(null);
        when(cityServicePort.getCityByNameAndDepartmentName("NonExistentCity", "NonExistentDepartment"))
                .thenThrow(new ElementNotFoundException("-CityUseCase- No se encontró ninguna ciudad con el nombre 'NonExistentCity' en el departamento 'NonExistentDepartment'."));

        // Act & Assert
        assertThrows(ElementNotFoundException.class, () -> ubicationUseCase.save(newUbication, "NonExistentCity", "NonExistentDepartment"));

        verify(ubicationValidator, times(1)).validateSectorName("SimpleSector");
        verify(cityServicePort, times(1)).getCityByNameAndDepartmentName("NonExistentCity", "NonExistentDepartment");
        verify(cityServicePort, never()).getUniqueCityByName(any());
        verify(ubicationPersistencePort, never()).getUbicationBySectorAndCityId(any(), any());
        verify(ubicationPersistencePort, never()).save(any());
    }

    @Test
    void save_shouldThrowElementAmbiguousNameException_whenMultipleCitiesFoundByNameAndDepartmentNameNotProvided() {
        // Arrange
        UbicationModel newUbication = UbicationModelFactoryForTest.createUbicationModelWithNewUbication(null);
        when(cityServicePort.getUniqueCityByName("CommonCity"))
                .thenThrow(new ElementAmbiguousNameException("-CityUseCase- Se encontraron 2 ciudades con el nombre 'CommonCity'. Intente nuevamente proporcionando el campo departmentName."));

        // Act & Assert
        assertThrows(ElementAmbiguousNameException.class, () -> ubicationUseCase.save(newUbication, "CommonCity", null));

        verify(ubicationValidator, times(1)).validateSectorName("SimpleSector");
        verify(cityServicePort, times(1)).getUniqueCityByName("CommonCity");
        verify(cityServicePort, never()).getCityByNameAndDepartmentName(any(), any());
        verify(ubicationPersistencePort, never()).getUbicationBySectorAndCityId(any(), any());
        verify(ubicationPersistencePort, never()).save(any());
    }

    @Test
    void getUbications_shouldReturnPageInfo_whenValidPageAndSizeAscending() {
        // Arrange
        String searchText = "test";
        int page = 0;
        int size = 10;
        boolean orderAsc = true;
        String sortBy = "cityName";
        List<UbicationModel> ubicationList = UbicationModelPaginationFactoryForTest.createUbicationModelList(15);
        PageInfo<UbicationModel> expectedPageInfo = UbicationModelPaginationFactoryForTest.createPageInfo(ubicationList.subList(0, 10), 15, 2, page, size, true, false);
        when(ubicationPersistencePort.getUbications(searchText, page, size, sortBy, "asc")).thenReturn(expectedPageInfo);

        // Act
        PageInfo<UbicationModel> actualPageInfo = ubicationUseCase.getUbications(searchText, page, size, sortBy, orderAsc);

        // Assert
        assertEquals(expectedPageInfo, actualPageInfo);
        verify(paginationValidator, times(1)).validatePage(page);
        verify(paginationValidator, times(1)).validatePage(size);
        verify(ubicationPersistencePort, times(1)).getUbications(searchText, page, size, sortBy, "asc");
    }

    @Test
    void getUbications_shouldReturnEmptyPageInfo_whenNoUbications() {
        // Arrange
        String searchText = "";
        int page = 0;
        int size = 10;
        boolean orderAsc = true;
        String sortBy = "departmentName";
        PageInfo<UbicationModel> expectedPageInfo = UbicationModelPaginationFactoryForTest.createEmptyPageInfo(page, size);
        when(ubicationPersistencePort.getUbications(searchText, page, size, sortBy, "asc")).thenReturn(expectedPageInfo);

        // Act
        PageInfo<UbicationModel> actualPageInfo = ubicationUseCase.getUbications(searchText, page, size, sortBy, orderAsc);

        // Assert
        assertEquals(expectedPageInfo, actualPageInfo);
        verify(paginationValidator, times(1)).validatePage(page);
        verify(paginationValidator, times(1)).validatePage(size);
        verify(ubicationPersistencePort, times(1)).getUbications(searchText, page, size, sortBy, "asc");
    }

    @Test
    void getUbications_shouldReturnPageInfo_whenDescendingOrder() {
        // Arrange
        String searchText = null;
        int page = 1;
        int size = 5;
        boolean orderAsc = false;
        String sortBy = "id";
        List<UbicationModel> ubicationList = UbicationModelPaginationFactoryForTest.createUbicationModelList(15);
        PageInfo<UbicationModel> expectedPageInfo = UbicationModelPaginationFactoryForTest.createPageInfo(ubicationList.subList(5, 10), 15, 3, page, size, true, true);
        when(ubicationPersistencePort.getUbications(searchText, page, size, sortBy, "desc")).thenReturn(expectedPageInfo);

        // Act
        PageInfo<UbicationModel> actualPageInfo = ubicationUseCase.getUbications(searchText, page, size, sortBy, orderAsc);

        // Assert
        assertEquals(expectedPageInfo, actualPageInfo);
        verify(paginationValidator, times(1)).validatePage(page);
        verify(paginationValidator, times(1)).validatePage(size);
        verify(ubicationPersistencePort, times(1)).getUbications(searchText, page, size, sortBy, "desc");
    }
}