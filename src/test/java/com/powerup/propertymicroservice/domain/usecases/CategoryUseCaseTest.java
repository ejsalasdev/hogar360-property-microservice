package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.domain.exceptions.CategoryAlreadyExistsException;
import com.powerup.propertymicroservice.domain.factories.CategoryModelFactory;
import com.powerup.propertymicroservice.domain.model.CategoryModel;
import com.powerup.propertymicroservice.domain.ports.out.CategoryPersistencePort;
import com.powerup.propertymicroservice.domain.validations.CategoryValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryUseCaseTest {

    @Mock
    private CategoryPersistencePort categoryPersistencePort;

    @Mock
    private CategoryValidator categoryValidator;

    @InjectMocks
    private CategoryUseCase categoryUseCase;

    @Test
    void When_CategoryDoesNotExist_Expect_CategoryToBeSavedSuccessfully() {
        //Arrange
        CategoryModel newCategory = CategoryModelFactory.createCategoryModelWithNewCategory("Description");
        when(categoryPersistencePort.getCategoryByName(anyString())).thenReturn(Optional.empty());
        doNothing().when(categoryPersistencePort).save(newCategory);
        doNothing().when(categoryValidator).validateName(newCategory.getName());
        doNothing().when(categoryValidator).validateDescription(newCategory.getDescription());

        // Act
        categoryUseCase.save(newCategory);

        // Assert
        verify(categoryPersistencePort, times(1)).save(newCategory);
    }

    @Test
    void Expect_CategoryAlreadyExistsException_When_CategoryAlreadyExists() {
        //Arrange
        CategoryModel existingCategory = CategoryModelFactory.createCategoryModelWithNewCategory("Description");
        when(categoryPersistencePort.getCategoryByName(anyString())).thenReturn(Optional.of(existingCategory));
        doNothing().when(categoryValidator).validateName(existingCategory.getName());
        doNothing().when(categoryValidator).validateDescription(existingCategory.getDescription());

        //Act & Assert
        assertThrows(CategoryAlreadyExistsException.class, () -> categoryUseCase.save(existingCategory));
        verify(categoryPersistencePort, never()).save(existingCategory);

    }
}