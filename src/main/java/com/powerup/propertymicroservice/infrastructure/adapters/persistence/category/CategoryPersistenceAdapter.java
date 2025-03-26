package com.powerup.propertymicroservice.infrastructure.adapters.persistence.category;

import com.powerup.propertymicroservice.domain.model.CategoryModel;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;
import com.powerup.propertymicroservice.domain.ports.out.CategoryPersistencePort;
import com.powerup.propertymicroservice.infrastructure.entities.CategoryEntity;
import com.powerup.propertymicroservice.infrastructure.mappers.CategoryEntityMapper;
import com.powerup.propertymicroservice.infrastructure.repositories.mysql.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements CategoryPersistencePort {

    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public void save(CategoryModel categoryModel) {
        categoryRepository.save(categoryEntityMapper.modelToEntity(categoryModel));
    }

    @Override
    public Optional<CategoryModel> getCategoryByName(String categoryName) {
        return categoryRepository.findByName(categoryName).map(categoryEntityMapper::entityToModel);
    }

    @Override
    public PageInfo<CategoryModel> getCategories(Integer page, Integer size, String sortField, String sortDirection) {
        Sort sort = Sort.by(sortField);
        if (sortDirection.equalsIgnoreCase("desc")) {
            sort = sort.descending();
        }
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<CategoryEntity> categoryEntityPage = categoryRepository.findAll(pageable);

        List<CategoryModel> categories = categoryEntityPage.getContent().stream()
                .map(categoryEntityMapper::entityToModel)
                .toList();

        return new PageInfo<>(
                categories,
                categoryEntityPage.getTotalElements(),
                categoryEntityPage.getTotalPages(),
                categoryEntityPage.getNumber(),
                categoryEntityPage.getSize(),
                categoryEntityPage.hasNext(),
                categoryEntityPage.hasPrevious()
        );
    }
}