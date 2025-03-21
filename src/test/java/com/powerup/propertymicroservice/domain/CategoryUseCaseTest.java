package com.powerup.propertymicroservice.domain;

import com.powerup.propertymicroservice.domain.factories.CategoryModelFactory;
import com.powerup.propertymicroservice.domain.model.CategoryModel;
import com.powerup.propertymicroservice.domain.ports.out.CategoryPersistencePort;
import com.powerup.propertymicroservice.domain.usecases.CategoryUseCase;

import com.powerup.propertymicroservice.domain.validations.CategoryValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryUseCaseTest {

    @Mock
    private CategoryPersistencePort categoryPersistencePort;

    @Mock
    private CategoryValidator categoryValidator;

    @InjectMocks
    private CategoryUseCase categoryUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void When_CategoryDoesNotExist_Expect_CategoryToBeSavedSuccessfully() {
        // Arrange
        CategoryModel newCategory = CategoryModelFactory.createCategoryModelWithNewCategory("Description");
        when(categoryPersistencePort.getCategoryByName(anyString())).thenReturn(Optional.empty());
        doNothing().when(categoryPersistencePort).save(any(CategoryModel.class)); // Cambio aquí

        // Act
        categoryUseCase.save(newCategory);

        // Assert
        verify(categoryPersistencePort, times(1)).save(any(CategoryModel.class)); // Cambio aqui tambien
    }

}
