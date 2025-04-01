package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.domain.exceptions.ElementAlreadyExistsException;
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
    void When_NewUbicationAndExistingCity_Expect_UbicationToBeSavedSuccessfully() {
        // Arrange
        String cityName = "SimpleCity";
        String sector = "SimpleSector";
        Long cityId = 1L;
        DepartmentModel department = new DepartmentModel(1L, "SimpleDepartment", null);
        CityModel existingCity = CityModelFactoryForTest.createExistingCityModel(cityId, cityName, "Simple Description", department);
        UbicationModel newUbicationAttempt = UbicationModelFactoryForTest.createUbicationModelWithNewUbication(existingCity);

        when(cityServicePort.getCityByName(cityName)).thenReturn(existingCity);
        doNothing().when(ubicationValidator).validateSectorName(sector);
        when(ubicationPersistencePort.getUbicationBySectorAndCityId(sector, cityId)).thenReturn(Optional.empty());

        // Act
        ubicationUseCase.save(newUbicationAttempt, cityName);

        // Assert
        verify(cityServicePort, times(1)).getCityByName(cityName);
        verify(ubicationValidator, times(1)).validateSectorName(sector);
        verify(ubicationPersistencePort, times(1)).getUbicationBySectorAndCityId(sector, cityId);
        verify(ubicationPersistencePort, times(1)).save(new UbicationModel(null, sector, existingCity));
    }

    @Test
    void Expect_ElementAlreadyExistsException_When_UbicationAlreadyExistsInCity() {
        // Arrange
        String cityName = "ExistingCity";
        String sector = "ExistingSector";
        Long cityId = 2L;
        DepartmentModel department = new DepartmentModel(2L, "ExistingDepartment", null);
        CityModel existingCity = CityModelFactoryForTest.createExistingCityModel(cityId, cityName, "Existing Description", department);
        UbicationModel existingUbication = UbicationModelFactoryForTest.createExistingUbicationModel(15L, sector, existingCity);
        UbicationModel newUbicationAttempt = UbicationModelFactoryForTest.createNewUbicationModelWithSectorAndCity(sector, existingCity); // Usando el sector correcto

        when(cityServicePort.getCityByName(cityName)).thenReturn(existingCity);
        doNothing().when(ubicationValidator).validateSectorName(sector);
        when(ubicationPersistencePort.getUbicationBySectorAndCityId(sector, cityId)).thenReturn(Optional.of(existingUbication));

        // Act & Assert
        assertThrows(ElementAlreadyExistsException.class, () -> ubicationUseCase.save(newUbicationAttempt, cityName));

        // Assert
        verify(ubicationPersistencePort, never()).save(any(UbicationModel.class));
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