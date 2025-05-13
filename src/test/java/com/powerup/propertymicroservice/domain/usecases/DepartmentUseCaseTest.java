package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.domain.exceptions.ElementNotFoundException;
import com.powerup.propertymicroservice.domain.model.DepartmentModel;
import com.powerup.propertymicroservice.domain.ports.out.DepartmentPersistencePort;
import com.powerup.propertymicroservice.domain.utils.factories.department.DepartmentModelFactoryForTest;
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
class DepartmentUseCaseTest {

    @Mock
    private DepartmentPersistencePort departmentPersistencePort;

    @Mock
    private DepartmentValidator departmentValidator;

    @InjectMocks
    private DepartmentUseCase departmentUseCase;

    private DepartmentModel department1;
    private DepartmentModel department2;

    @BeforeEach
    void setUp() {
        department1 = DepartmentModelFactoryForTest.createExistingDepartmentModel(1L, "Antioquia", "Departamento de Antioquia");
        department2 = DepartmentModelFactoryForTest.createExistingDepartmentModel(2L, "Cundinamarca", "Departamento de Cundinamarca");
    }

    @Test
    void getDepartmentByName_WhenDepartmentExists_ShouldReturnDepartment() {
        // Arrange
        when(departmentPersistencePort.getDepartmentByName("Antioquia"))
                .thenReturn(Optional.of(department1));

        // Act
        DepartmentModel result = departmentUseCase.getDepartmentByName("Antioquia");

        // Assert
        assertNotNull(result);
        assertEquals("Antioquia", result.getName());
        verify(departmentPersistencePort).getDepartmentByName("Antioquia");
    }

    @Test
    void getDepartmentByName_WhenDepartmentDoesNotExist_ShouldThrowException() {
        // Arrange
        when(departmentPersistencePort.getDepartmentByName("Inexistente"))
                .thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ElementNotFoundException.class, () -> 
            departmentUseCase.getDepartmentByName("Inexistente")
        );
        verify(departmentPersistencePort).getDepartmentByName("Inexistente");
    }

    @Test
    void getAllDepartments_WhenOrderAsc_ShouldReturnOrderedList() {
        // Arrange
        List<DepartmentModel> departments = Arrays.asList(department2, department1);
        when(departmentPersistencePort.findAll()).thenReturn(departments);

        // Act
        List<DepartmentModel> result = departmentUseCase.getAllDepartments(true);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Antioquia", result.get(0).getName());
        assertEquals("Cundinamarca", result.get(1).getName());
        verify(departmentPersistencePort).findAll();
    }

    @Test
    void getAllDepartments_WhenOrderDesc_ShouldReturnReversedList() {
        // Arrange
        List<DepartmentModel> departments = Arrays.asList(department1, department2);
        when(departmentPersistencePort.findAll()).thenReturn(departments);

        // Act
        List<DepartmentModel> result = departmentUseCase.getAllDepartments(false);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Cundinamarca", result.get(0).getName());
        assertEquals("Antioquia", result.get(1).getName());
        verify(departmentPersistencePort).findAll();
    }
}