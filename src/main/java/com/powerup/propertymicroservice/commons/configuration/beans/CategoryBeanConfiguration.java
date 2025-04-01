package com.powerup.propertymicroservice.commons.configuration.beans;

import com.powerup.propertymicroservice.domain.ports.in.CategoryServicePort;
import com.powerup.propertymicroservice.domain.ports.out.CategoryPersistencePort;
import com.powerup.propertymicroservice.domain.usecases.CategoryUseCase;
import com.powerup.propertymicroservice.domain.utils.validations.pagination.PaginationValidator;
import com.powerup.propertymicroservice.domain.utils.validations.categories.CategoryValidator;
import com.powerup.propertymicroservice.infrastructure.adapters.persistence.CategoryPersistenceAdapter;
import com.powerup.propertymicroservice.infrastructure.mappers.CategoryEntityMapper;
import com.powerup.propertymicroservice.infrastructure.repositories.mysql.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@RequiredArgsConstructor
@Import(CommonBeanConfiguration.class)
public class CategoryBeanConfiguration {

    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Bean
    public CategoryPersistencePort categoryPersistencePort() {
        return new CategoryPersistenceAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public CategoryValidator categoryValidator() {
        return new CategoryValidator();
    }

    @Bean
    public CategoryServicePort categoryServicePort(
            CategoryPersistencePort categoryPersistencePort,
            CategoryValidator categoryValidator,
            PaginationValidator paginationValidator
    ) {
        return new CategoryUseCase(categoryPersistencePort, categoryValidator, paginationValidator);
    }
}
