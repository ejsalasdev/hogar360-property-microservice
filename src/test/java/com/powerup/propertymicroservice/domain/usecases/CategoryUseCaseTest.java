package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.domain.exceptions.CategoryAlreadyExistsException;
import com.powerup.propertymicroservice.domain.factories.CategoryModelFactoryForTest;
import com.powerup.propertymicroservice.domain.factories.CategoryModelPaginationFactoryForTest;
import com.powerup.propertymicroservice.domain.model.CategoryModel;
import com.powerup.propertymicroservice.domain.model.PageInfo;
import com.powerup.propertymicroservice.domain.ports.out.CategoryPersistencePort;
import com.powerup.propertymicroservice.domain.validations.CategoryPaginationValidator;
import com.powerup.propertymicroservice.domain.validations.CategoryValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
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
    
    @Mock
    private CategoryPaginationValidator categoryPaginationValidator;

    @InjectMocks
    private CategoryUseCase categoryUseCase;

    // Test for create categories
    
    @Test
    void When_CategoryDoesNotExist_Expect_CategoryToBeSavedSuccessfully() {
        //Arrange
        CategoryModel newCategory = CategoryModelFactoryForTest.createCategoryModelWithNewCategory("Description");
        when(categoryPersistencePort.getCategoryByName(anyString())).thenReturn(Optional.empty());

        // Act
        categoryUseCase.save(newCategory);

        // Assert
        verify(categoryPersistencePort, times(1)).save(newCategory);
    }

    @Test
    void Expect_CategoryAlreadyExistsException_When_CategoryAlreadyExists() {
        //Arrange
        CategoryModel existingCategory = CategoryModelFactoryForTest.createCategoryModelWithNewCategory("Description");
        when(categoryPersistencePort.getCategoryByName(anyString())).thenReturn(Optional.of(existingCategory));

        //Act & Assert
        assertThrows(CategoryAlreadyExistsException.class, () -> categoryUseCase.save(existingCategory));
        verify(categoryPersistencePort, never()).save(existingCategory);

    }
    
    
    // Test for pagination

    @Test
    void getCategories_shouldReturnPageInfo_whenValidPageAndSize() {
        // Arrange
        int page = 0;
        int size = 10;
        boolean orderAsc = true;
        List<CategoryModel> categoryList = CategoryModelPaginationFactoryForTest.createCategoryModelList(10);
        PageInfo<CategoryModel> expectedPageInfo = CategoryModelPaginationFactoryForTest.createPageInfo(categoryList, 100, 10, page, size, true, false);

        when(categoryPersistencePort.getCategories(page, size, "name", "asc")).thenReturn(expectedPageInfo);

        // Act
        PageInfo<CategoryModel> actualPageInfo = categoryUseCase.getCategories(page, size, orderAsc);

        // Assert
        assertEquals(expectedPageInfo, actualPageInfo);
    }

    @Test
    void getCategories_shouldReturnEmptyPageInfo_whenNoCategories() {
        // Arrange
        int page = 0;
        int size = 10;
        boolean orderAsc = true;
        List<CategoryModel> emptyCategoryList = CategoryModelPaginationFactoryForTest.createCategoryModelList(0);
        PageInfo<CategoryModel> expectedPageInfo = CategoryModelPaginationFactoryForTest.createPageInfo(emptyCategoryList, 0, 0, page, size, false, false);

        when(categoryPersistencePort.getCategories(page, size, "name", "asc")).thenReturn(expectedPageInfo);

        // Act
        PageInfo<CategoryModel> actualPageInfo = categoryUseCase.getCategories(page, size, orderAsc);

        // Assert
        assertEquals(expectedPageInfo, actualPageInfo);
    }

    @Test
    void getCategories_shouldReturnPageInfo_whenDescendingOrder() {
        // Arrange
        int page = 1;
        int size = 5;
        boolean orderAsc = false;
        List<CategoryModel> categoryList = CategoryModelPaginationFactoryForTest.createCategoryModelList(5);
        PageInfo<CategoryModel> expectedPageInfo = CategoryModelPaginationFactoryForTest.createPageInfo(categoryList, 20, 4, page, size, false, true);

        when(categoryPersistencePort.getCategories(page, size, "name", "desc")).thenReturn(expectedPageInfo);

        // Act
        PageInfo<CategoryModel> actualPageInfo = categoryUseCase.getCategories(page, size, orderAsc);

        // Assert
        assertEquals(expectedPageInfo, actualPageInfo);
    }
}