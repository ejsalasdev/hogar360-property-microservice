package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.domain.exceptions.ElementNotFoundException;
import com.powerup.propertymicroservice.domain.model.DepartmentModel;
import com.powerup.propertymicroservice.domain.ports.out.DepartmentPersistencePort;
import com.powerup.propertymicroservice.domain.utils.factories.department.DepartmentModelFactoryForTest;
import com.powerup.propertymicroservice.domain.utils.validations.departments.DepartmentValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentUseCaseTest {

    @Mock
    private DepartmentPersistencePort departmentPersistencePort;

    @Mock
    private DepartmentValidator departmentValidator;

    @InjectMocks
    private DepartmentUseCase departmentUseCase;

    @Test
    void getDepartmentByName_shouldReturnDepartment_whenDepartmentExists() {
        // Arrange
        String departmentName = "Antioquia";
        DepartmentModel expectedDepartment = DepartmentModelFactoryForTest.createExistingDepartmentModel(1L, departmentName, "Description");
        when(departmentPersistencePort.getDepartmentByName(departmentName)).thenReturn(Optional.of(expectedDepartment));

        // Act
        DepartmentModel actualDepartment = departmentUseCase.getDepartmentByName(departmentName);

        // Assert
        assertEquals(expectedDepartment, actualDepartment);
        verify(departmentValidator, times(1)).validateDepartmentName(departmentName);
        verify(departmentPersistencePort, times(1)).getDepartmentByName(departmentName);
    }

    @Test
    void getDepartmentByName_shouldThrowElementNotFoundException_whenDepartmentDoesNotExist() {
        // Arrange
        String departmentName = "NonExistentDepartment";
        when(departmentPersistencePort.getDepartmentByName(departmentName)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ElementNotFoundException.class, () -> departmentUseCase.getDepartmentByName(departmentName));
        verify(departmentValidator, times(1)).validateDepartmentName(departmentName);
        verify(departmentPersistencePort, times(1)).getDepartmentByName(departmentName);
    }
}