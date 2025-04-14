package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.commons.constants.CommonConstants;
import com.powerup.propertymicroservice.domain.enums.PublicationStatus;
import com.powerup.propertymicroservice.domain.exceptions.ElementNotFoundException;
import com.powerup.propertymicroservice.domain.exceptions.InvalidFormatExcepcion;
import com.powerup.propertymicroservice.domain.model.*;
import com.powerup.propertymicroservice.domain.ports.in.CategoryServicePort;
import com.powerup.propertymicroservice.domain.ports.in.UbicationServicePort;
import com.powerup.propertymicroservice.domain.ports.out.HousePersistencePort;
import com.powerup.propertymicroservice.domain.utils.validations.houses.HouseValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HouseUseCaseTest {

    @Mock
    private HousePersistencePort housePersistencePort;

    @Mock
    private CategoryServicePort categoryServicePort;

    @Mock
    private UbicationServicePort ubicationServicePort;

    @Mock
    private HouseValidator houseValidator;

    private HouseUseCase houseUseCase;

    private HouseModel houseModel;
    private LocalDate currentDate;
    private CategoryModel categoryModel;
    private UbicationModel ubicationModel;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        currentDate = LocalDate.now(ZoneId.of(CommonConstants.TIME_ZONE));
        categoryModel = new CategoryModel(1L, "newCategory", "description");
        ubicationModel = new UbicationModel(
                1L, "newSector",
                new CityModel(
                        1L,
                        "city",
                        "description",
                        new DepartmentModel(
                                1L,
                                "department",
                                "description"
                        )
                )
        );

        houseModel = new HouseModel();
        houseModel.setName("House Test");
        houseModel.setDescription("House Test Description");
        houseModel.setCategory(categoryModel);
        houseModel.setNumberOfRooms(3);
        houseModel.setNumberOfBathrooms(2);
        houseModel.setPrice(BigDecimal.valueOf(250000));
        houseModel.setUbication(ubicationModel);
        houseModel.setAddress("Fake Street 123");
        houseModel.setActivePublicationDate(currentDate);

        houseUseCase = new HouseUseCase(housePersistencePort, categoryServicePort, ubicationServicePort, houseValidator);
    }

    @Test
    void When_ValidHouseProvidedAndActiveDateIsToday_Expect_HouseSavedWithPublishedStatus() {
        // Arrange
        when(categoryServicePort.getCategoryById(1L)).thenReturn(categoryModel);
        when(ubicationServicePort.getUbicationById(1L)).thenReturn(ubicationModel);

        // Act
        houseUseCase.save(houseModel);

        // Assert
        verify(houseValidator, times(1)).validate(houseModel, currentDate);
        verify(housePersistencePort, times(1)).save(houseModel);
        assertEquals(PublicationStatus.PUBLISHED, houseModel.getPublicationStatus());
        assertEquals(currentDate, houseModel.getPublicationDate());
        assertEquals(categoryModel, houseModel.getCategory());
        assertEquals(ubicationModel, houseModel.getUbication());
    }

    @Test
    void When_ValidationFails_Expect_ValidationExceptionIsThrownAndNoFurtherActions() {
        // Arrange
        Mockito.doThrow(new InvalidFormatExcepcion("Invalid data House")).when(houseValidator).validate(houseModel, currentDate);

        // Act & Assert
        assertThrows(InvalidFormatExcepcion.class, () -> houseUseCase.save(houseModel));
        verify(categoryServicePort, never()).getCategoryById(anyLong());
        verify(ubicationServicePort, never()).getUbicationById(anyLong());
        verify(housePersistencePort, never()).save(any());
    }

    @Test
    void When_CategoryNotFound_Expect_NotFoundExceptionIsThrownAndNoSaveAttempt() {
        // Arrange
        when(categoryServicePort.getCategoryById(1L)).thenThrow(new ElementNotFoundException("Category not found"));

        // Act & Assert
        assertThrows(ElementNotFoundException.class, () -> houseUseCase.save(houseModel));
        verify(houseValidator, times(1)).validate(houseModel, currentDate);
        verify(ubicationServicePort, never()).getUbicationById(anyLong());
        verify(housePersistencePort, never()).save(any());
    }

    @Test
    void When_UbicationNotFound_Expect_NotFoundExceptionIsThrownAndNoSaveAttempt() {
        // Arrange
        when(categoryServicePort.getCategoryById(1L)).thenReturn(categoryModel);
        when(ubicationServicePort.getUbicationById(1L)).thenThrow(new ElementNotFoundException("Ubication not found"));

        // Act & Assert
        assertThrows(ElementNotFoundException.class, () -> houseUseCase.save(houseModel));
        verify(houseValidator, times(1)).validate(houseModel, currentDate);
        verify(housePersistencePort, never()).save(any());
    }

    @Test
    void When_ActiveDateIsFuture_Expect_HouseSavedWithPublicationPausedStatus() {
        // Arrange
        LocalDate futureDate = currentDate.plusDays(5);
        houseModel.setActivePublicationDate(futureDate);
        when(categoryServicePort.getCategoryById(1L)).thenReturn(categoryModel);
        when(ubicationServicePort.getUbicationById(1L)).thenReturn(ubicationModel);

        // Act
        houseUseCase.save(houseModel);

        // Assert
        verify(houseValidator, times(1)).validate(houseModel, currentDate);
        verify(housePersistencePort, times(1)).save(houseModel);
        assertEquals(PublicationStatus.PUBLICATION_PAUSED, houseModel.getPublicationStatus());
        assertEquals(currentDate, houseModel.getPublicationDate());
    }

    @Test
    void When_ActiveDateIsPast_Expect_HouseSavedWithPublicationPausedStatus() {
        // Arrange
        LocalDate pastDate = currentDate.minusDays(5);
        houseModel.setActivePublicationDate(pastDate);
        when(categoryServicePort.getCategoryById(1L)).thenReturn(categoryModel);
        when(ubicationServicePort.getUbicationById(1L)).thenReturn(ubicationModel);

        // Act
        houseUseCase.save(houseModel);

        // Assert
        verify(houseValidator, times(1)).validate(houseModel, currentDate);
        verify(housePersistencePort, times(1)).save(houseModel);
        assertEquals(PublicationStatus.PUBLICATION_PAUSED, houseModel.getPublicationStatus());
        assertEquals(currentDate, houseModel.getPublicationDate());
    }

    @Test
    void When_SaveIsCalled_CategoryAndUbicationAreFetchedAndSet() {
        // Arrange
        when(categoryServicePort.getCategoryById(1L)).thenReturn(categoryModel);
        when(ubicationServicePort.getUbicationById(1L)).thenReturn(ubicationModel);

        // Act
        houseUseCase.save(houseModel);

        // Assert
        verify(categoryServicePort, times(1)).getCategoryById(1L);
        verify(ubicationServicePort, times(1)).getUbicationById(1L);
        assertEquals(categoryModel, houseModel.getCategory());
        assertEquals(ubicationModel, houseModel.getUbication());
    }

    @Test
    void When_SaveIsCalled_PublicationDateIsAlwaysCurrentDate() {
        // Arrange
        LocalDate anotherDate = currentDate.plusDays(10);
        houseModel.setActivePublicationDate(anotherDate);
        when(categoryServicePort.getCategoryById(1L)).thenReturn(categoryModel);
        when(ubicationServicePort.getUbicationById(1L)).thenReturn(ubicationModel);

        // Act
        houseUseCase.save(houseModel);

        // Assert
        assertEquals(currentDate, houseModel.getPublicationDate());
    }
}