package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.commons.constants.CommonConstants;
import com.powerup.propertymicroservice.domain.enums.PublicationStatus;
import com.powerup.propertymicroservice.domain.exceptions.ElementNotFoundException;
import com.powerup.propertymicroservice.domain.exceptions.InvalidFormatExcepcion;
import com.powerup.propertymicroservice.domain.exceptions.InvalidPageNumberException;
import com.powerup.propertymicroservice.domain.exceptions.InvalidPageSizeException;
import com.powerup.propertymicroservice.domain.model.*;
import com.powerup.propertymicroservice.domain.ports.in.CategoryServicePort;
import com.powerup.propertymicroservice.domain.ports.in.UbicationServicePort;
import com.powerup.propertymicroservice.domain.ports.out.AuthenticatedUserPort;
import com.powerup.propertymicroservice.domain.ports.out.HousePersistencePort;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;
import com.powerup.propertymicroservice.domain.utils.validations.houses.HouseValidator;
import com.powerup.propertymicroservice.domain.utils.validations.pagination.PaginationValidator;
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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
    
    @Mock
    private PaginationValidator paginationValidator;
    
    @Mock
    private AuthenticatedUserPort authenticatedUserPort;

    private HouseUseCase houseUseCase;

    private HouseModel houseModel;
    private LocalDate currentDate;
    private CategoryModel categoryModel;
    private UbicationModel ubicationModel;
    private PageInfo<HouseModel> mockPageInfo;

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


        HouseModel houseModel1 = new HouseModel();
        houseModel1.setId(1L);
        houseModel1.setName("House Test 1");
        HouseModel houseModel2 = new HouseModel();
        houseModel2.setId(2L);
        houseModel2.setName("House Test 2");

        
        List<HouseModel> content = Arrays.asList(houseModel1, houseModel2);
        mockPageInfo = new PageInfo<>(content, 2, 1, 0, 10, false, false);

        houseUseCase = new HouseUseCase(
                housePersistencePort, categoryServicePort, ubicationServicePort,
                houseValidator, paginationValidator, authenticatedUserPort);
    }

    @Test
    void When_ValidHouseProvidedAndActiveDateIsToday_Expect_HouseSavedWithPublishedStatus() {
        // Arrange
        Long expectedSellerId = 123L;
        when(categoryServicePort.getCategoryById(1L)).thenReturn(categoryModel);
        when(ubicationServicePort.getUbicationById(1L)).thenReturn(ubicationModel);
        when(authenticatedUserPort.getCurrentUserId()).thenReturn(expectedSellerId);

        // Act
        houseUseCase.save(houseModel);

        // Assert
        verify(houseValidator, times(1)).validate(houseModel, currentDate);
        verify(housePersistencePort, times(1)).save(houseModel);
        assertEquals(PublicationStatus.PUBLISHED, houseModel.getPublicationStatus());
        assertEquals(currentDate, houseModel.getPublicationDate());
        assertEquals(categoryModel, houseModel.getCategory());
        assertEquals(ubicationModel, houseModel.getUbication());
        assertEquals(expectedSellerId, houseModel.getSellerId());
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

    @Test
    void When_GetHousesIsCalledWithValidParameters_Expect_ReturnsPageInfo() {
        // Arrange
        Integer page = 0;
        Integer size = 10;
        String sortBy = "price";
        Long categoryId = 1L;
        Long ubicationId = 2L;
        Integer minRooms = 2;
        Integer maxRooms = 4;
        Integer minBathrooms = 1;
        Integer maxBathrooms = 2;
        BigDecimal minPrice = BigDecimal.valueOf(100000000);
        BigDecimal maxPrice = BigDecimal.valueOf(300000000);
        boolean orderAsc = true;
        String sortDirection = "asc";

        when(housePersistencePort.getHouses(
                page,
                size,
                sortBy,
                categoryId,
                ubicationId,
                minRooms,
                maxRooms,
                minBathrooms,
                maxBathrooms,
                minPrice,
                maxPrice,
                sortDirection
        )).thenReturn(mockPageInfo);

        // Act
        PageInfo<HouseModel> result = houseUseCase.getHouses(
                page,
                size,
                sortBy,
                categoryId,
                ubicationId,
                minRooms,
                maxRooms,
                minBathrooms,
                maxBathrooms,
                minPrice,
                maxPrice,
                orderAsc
        );

        // Assert
        assertEquals(mockPageInfo, result);
        verify(paginationValidator, times(1)).validatePage(page);
        verify(paginationValidator, times(1)).validateSize(size);
        verify(housePersistencePort, times(1)).getHouses(
                page,
                size,
                sortBy,
                categoryId,
                ubicationId,
                minRooms,
                maxRooms,
                minBathrooms,
                maxBathrooms,
                minPrice,
                maxPrice,
                sortDirection
        );
    }

    @Test
    void When_GetHousesIsCalledWithDescendingOrder_Expect_CallsPersistencePortWithCorrectSortDirection() {
        // Arrange
        Integer page = 0;
        Integer size = 10;
        String sortBy = "numberOfRooms";
        boolean orderAsc = false;
        String sortDirection = "desc";

        when(housePersistencePort.getHouses(
                eq(page),
                eq(size),
                eq(sortBy),
                isNull(),
                isNull(),
                isNull(),
                isNull(),
                isNull(),
                isNull(),
                isNull(),
                isNull(),
                eq(sortDirection)
        )).thenReturn(mockPageInfo);

        // Act
        houseUseCase.getHouses(
                page,
                size,
                sortBy,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                orderAsc
        );

        // Assert
        verify(housePersistencePort, times(1)).getHouses(
                page,
                size,
                sortBy,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                sortDirection
        );
    }

    @Test
    void When_GetHousesIsCalledWithInvalidPage_Expect_CallsPaginationValidatorAndThrowsException(){
        // Arrange
        Integer page = -1;
        Integer size = 10;
        String sortBy = "price";
        boolean orderAsc = true;

        doThrow(new InvalidPageNumberException("Invalid page number")).when(paginationValidator).validatePage(page);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> houseUseCase.getHouses(
                page,
                size,
                sortBy,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                orderAsc
        ));

        verify(paginationValidator, times(1)).validatePage(page);
        verify(paginationValidator, never()).validateSize(anyInt());
        verify(housePersistencePort, never()).getHouses(any(), any(), any(), any(), any(), any(), any(), any(), any(), any(), any(), any());
    }

    @Test
    void When_GetHousesIsCalledWithInvalidSize_Expect_CallsPaginationValidatorAndThrowsException() {
        // Arrange
        Integer page = 0;
        Integer size = 0;
        String sortBy = "price";
        boolean orderAsc = true;

        doThrow(new InvalidPageSizeException("Invalid page size")).when(paginationValidator).validateSize(size);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> houseUseCase.getHouses(
                page,
                size,
                sortBy,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                orderAsc
        ));

        verify(paginationValidator, times(1)).validateSize(size);
        verify(paginationValidator, times(1)).validatePage(page);
        verify(housePersistencePort, never()).getHouses(any(), any(), any(), any(), any(), any(), any(), any(), any(), any(), any(), any());
    }

    @Test
    void When_CategoryHasHouses_Expect_True() {
        // Arrange
        Long categoryId = 1L;
        when(housePersistencePort.existByCategoryId(categoryId)).thenReturn(true);

        // Act
        boolean result = houseUseCase.existsByCategoryId(categoryId);

        // Assert
        assertTrue(result);
        verify(housePersistencePort, times(1)).existByCategoryId(categoryId);
    }

    @Test
    void When_CategoryHasNoHouses_Expect_False() {
        // Arrange
        Long categoryId = 1L;
        when(housePersistencePort.existByCategoryId(categoryId)).thenReturn(false);

        // Act
        boolean result = houseUseCase.existsByCategoryId(categoryId);

        // Assert
        assertFalse(result);
        verify(housePersistencePort, times(1)).existByCategoryId(categoryId);
    }

    @Test
    void When_HouseExists_Expect_HouseToBeReturned() {
        // Arrange
        Long houseId = 1L;
        HouseModel expectedHouse = new HouseModel();
        expectedHouse.setId(houseId);
        expectedHouse.setName("Test House");
        when(housePersistencePort.getHouseById(houseId)).thenReturn(Optional.of(expectedHouse));

        // Act
        HouseModel actualHouse = houseUseCase.getHouseById(houseId);

        // Assert
        assertEquals(expectedHouse, actualHouse);
        verify(housePersistencePort, times(1)).getHouseById(houseId);
    }

    @Test
    void When_HouseDoesNotExist_Expect_ElementNotFoundException() {
        // Arrange
        Long houseId = 1L;
        when(housePersistencePort.getHouseById(houseId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ElementNotFoundException.class, () -> houseUseCase.getHouseById(houseId));
        verify(housePersistencePort, times(1)).getHouseById(houseId);
    }
}