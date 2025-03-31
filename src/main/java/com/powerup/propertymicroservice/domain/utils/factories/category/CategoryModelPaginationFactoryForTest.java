package com.powerup.propertymicroservice.domain.utils.factories.category;

import com.powerup.propertymicroservice.domain.model.CategoryModel;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;

import java.util.ArrayList;
import java.util.List;

public class CategoryModelPaginationFactoryForTest {

    private CategoryModelPaginationFactoryForTest() {
    }

    public static List<CategoryModel> createCategoryModelList(int size) {
        List<CategoryModel> categoryList = new ArrayList<>();
        for (long i = 1; i <= size; i++) {
            CategoryModel category = new CategoryModel(i, "Category " + i, "Description " + i);
            categoryList.add(category);
        }
        return categoryList;
    }

    public static PageInfo<CategoryModel> createPageInfo(List<CategoryModel> categoryList, long totalElements, int totalPages, int currentPage, int pageSize, boolean hasNext, boolean hasPrevious) {
        return new PageInfo<>(categoryList, totalElements, totalPages, currentPage, pageSize, hasNext, hasPrevious);
    }
}
