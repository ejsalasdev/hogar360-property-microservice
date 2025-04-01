package com.powerup.propertymicroservice.commons.configuration.beans;

import com.powerup.propertymicroservice.domain.utils.validations.pagination.PaginationValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonBeanConfiguration {
    
    @Bean
    public PaginationValidator paginationValidator() {
        return new PaginationValidator();
    }
}
