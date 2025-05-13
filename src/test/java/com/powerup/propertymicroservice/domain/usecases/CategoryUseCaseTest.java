package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.domain.exceptions.ElementAlreadyExistsException;
import com.powerup.propertymicroservice.domain.exceptions.ElementNotFoundException;
import com.powerup.propertymicroservice.domain.exceptions.CategoryInUseException;
import com.powerup.propertymicroservice.domain.utils.factories.category.CategoryModelFactoryForTest;
import com.powerup.propertymicroservice.domain.utils.factories.category.CategoryModelPaginationFactoryForTest;
import com.powerup.propertymicroservice.domain.model.CategoryModel;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;
import com.powerup.propertymicroservice.domain.ports.out.CategoryPersistencePort;
import com.powerup.propertymicroservice.domain.ports.in.HouseServicePort;
import com.powerup.propertymicroservice.domain.utils.validations.pagination.PaginationValidator;
import com.powerup.propertymicroservice.domain.utils.validations.categories.CategoryValidator;
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
    private PaginationValidator paginationValidator;

    @Mock
    private HouseServicePort houseServicePort;

    @InjectMocks
    private CategoryUseCase categoryUseCase;
    
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
        assertThrows(ElementAlreadyExistsException.class, () -> categoryUseCase.save(existingCategory));
        verify(categoryPersistencePort, never()).save(existingCategory);

    }

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

    @Test
    void When_CategoryExists_Expect_CategoryToBeReturned() {
        // Arrange
        Long categoryId = 1L;
        CategoryModel expectedCategory = CategoryModelFactoryForTest.createCategoryModel(categoryId, "Test Category", "Test Description");
        when(categoryPersistencePort.getCategoryById(categoryId)).thenReturn(Optional.of(expectedCategory));

        // Act
        CategoryModel actualCategory = categoryUseCase.getCategoryById(categoryId);

        // Assert
        assertEquals(expectedCategory, actualCategory);
        verify(categoryPersistencePort, times(1)).getCategoryById(categoryId);
    }

    @Test
    void When_CategoryDoesNotExist_Expect_ElementNotFoundException() {
        // Arrange
        Long categoryId = 1L;
        when(categoryPersistencePort.getCategoryById(categoryId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ElementNotFoundException.class, () -> categoryUseCase.getCategoryById(categoryId));
        verify(categoryPersistencePort, times(1)).getCategoryById(categoryId);
    }

    @Test
    void When_CategoryExistsAndNotInUse_Expect_CategoryToBeDeleted() {
        // Arrange
        Long categoryId = 1L;
        CategoryModel category = CategoryModelFactoryForTest.createCategoryModel(categoryId, "Test Category", "Test Description");
        when(categoryPersistencePort.getCategoryById(categoryId)).thenReturn(Optional.of(category));
        when(houseServicePort.existsByCategoryId(categoryId)).thenReturn(false);

        // Act
        categoryUseCase.deleteById(categoryId);

        // Assert
        verify(categoryPersistencePort, times(1)).getCategoryById(categoryId);
        verify(houseServicePort, times(1)).existsByCategoryId(categoryId);
        verify(categoryPersistencePort, times(1)).deleteById(categoryId);
    }

    @Test
    void When_CategoryDoesNotExist_Expect_ElementNotFoundExceptionOnDelete() {
        // Arrange
        Long categoryId = 1L;
        when(categoryPersistencePort.getCategoryById(categoryId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ElementNotFoundException.class, () -> categoryUseCase.deleteById(categoryId));
        verify(categoryPersistencePort, times(1)).getCategoryById(categoryId);
        verify(houseServicePort, never()).existsByCategoryId(anyLong());
        verify(categoryPersistencePort, never()).deleteById(anyLong());
    }

    @Test
    void When_CategoryInUse_Expect_CategoryInUseException() {
        // Arrange
        Long categoryId = 1L;
        CategoryModel category = CategoryModelFactoryForTest.createCategoryModel(categoryId, "Test Category", "Test Description");
        when(categoryPersistencePort.getCategoryById(categoryId)).thenReturn(Optional.of(category));
        when(houseServicePort.existsByCategoryId(categoryId)).thenReturn(true);

        // Act & Assert
        assertThrows(CategoryInUseException.class, () -> categoryUseCase.deleteById(categoryId));
        verify(categoryPersistencePort, times(1)).getCategoryById(categoryId);
        verify(houseServicePort, times(1)).existsByCategoryId(categoryId);
        verify(categoryPersistencePort, never()).deleteById(anyLong());
    }
}