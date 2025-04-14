package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.commons.constants.CommonConstants;
import com.powerup.propertymicroservice.domain.enums.PublicationStatus;
import com.powerup.propertymicroservice.domain.model.*;
import com.powerup.propertymicroservice.domain.ports.in.CategoryServicePort;
import com.powerup.propertymicroservice.domain.ports.in.UbicationServicePort;
import com.powerup.propertymicroservice.domain.ports.out.HousePersistencePort;
import com.powerup.propertymicroservice.domain.utils.validations.houses.HouseValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;
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
    
    @InjectMocks
    private HouseUseCase houseUseCase;

    private HouseModel houseModel;
    private LocalDate currentDate;
    private CategoryModel categoryModel;
    private UbicationModel ubicationModel;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        currentDate = LocalDate.now(ZoneId.of(CommonConstants.TIME_ZONE));
        categoryModel = new CategoryModel(1L, "Tipo", "Descripción");
        ubicationModel = new UbicationModel(
                1L, "Sector",
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
        houseModel.setName("Casa de Prueba");
        houseModel.setDescription("Descripción de la casa de prueba");
        houseModel.setCategory(new CategoryModel(1L, null, null));
        houseModel.setNumberOfRooms(3);
        houseModel.setNumberOfBathrooms(2);
        houseModel.setPrice(BigDecimal.valueOf(250000));
        houseModel.setUbication(new UbicationModel(1L, null, null));
        houseModel.setAddress("Calle Falsa 123");
        houseModel.setActivePublicationDate(currentDate);
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
}