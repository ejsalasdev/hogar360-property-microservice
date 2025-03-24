package com.powerup.propertymicroservice.commons.configuration.beans;

import com.powerup.propertymicroservice.domain.ports.in.CategoryServicePort;
import com.powerup.propertymicroservice.domain.ports.out.CategoryPersistencePort;
import com.powerup.propertymicroservice.domain.usecases.CategoryUseCase;
import com.powerup.propertymicroservice.domain.utils.validations.categories.CategoryPaginationValidator;
import com.powerup.propertymicroservice.domain.utils.validations.categories.CategoryValidator;
import com.powerup.propertymicroservice.infrastructure.adapters.persistence.CategoryPersistenceAdapter;
import com.powerup.propertymicroservice.infrastructure.mappers.CategoryEntityMapper;
import com.powerup.propertymicroservice.infrastructure.repositories.mysql.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Bean
    public CategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort(), categoryValidator(), categoryPaginationValidator());
    }

    @Bean
    public CategoryPersistencePort categoryPersistencePort() {
        return new CategoryPersistenceAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public CategoryValidator categoryValidator() {
        return new CategoryValidator();
    }

    @Bean
    public CategoryPaginationValidator categoryPaginationValidator() {
        return new CategoryPaginationValidator();
    }
}
