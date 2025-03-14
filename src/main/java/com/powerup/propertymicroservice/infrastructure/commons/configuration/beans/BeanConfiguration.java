package com.powerup.propertymicroservice.infrastructure.commons.configuration.beans;

import com.powerup.propertymicroservice.domain.ports.in.CategoryServicePort;
import com.powerup.propertymicroservice.domain.ports.out.CategoryPersistencePort;
import com.powerup.propertymicroservice.domain.usecases.CategoryUseCase;
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
    public CategoryPersistencePort categoryPersistencePort(){
        return new CategoryPersistenceAdapter(categoryRepository, categoryEntityMapper);
    }
    
    @Bean
    public CategoryServicePort categoryServicePort(){
        return new CategoryUseCase(categoryPersistencePort());
    }
}
