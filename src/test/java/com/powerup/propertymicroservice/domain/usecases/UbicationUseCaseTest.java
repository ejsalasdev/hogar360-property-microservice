package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.domain.exceptions.ElementAlreadyExistsException;
import com.powerup.propertymicroservice.domain.model.CityModel;
import com.powerup.propertymicroservice.domain.model.DepartmentModel;
import com.powerup.propertymicroservice.domain.model.UbicationModel;
import com.powerup.propertymicroservice.domain.ports.in.CityServicePort;
import com.powerup.propertymicroservice.domain.ports.out.UbicationPersistencePort;
import com.powerup.propertymicroservice.domain.utils.factories.city.CityModelFactoryForTest;
import com.powerup.propertymicroservice.domain.utils.factories.ubication.UbicationModelFactoryForTest;
import com.powerup.propertymicroservice.domain.utils.validations.ubications.UbicationValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

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

        // Assert (Verificar que no se intentó guardar)
        verify(ubicationPersistencePort, never()).save(any(UbicationModel.class));
    }
}