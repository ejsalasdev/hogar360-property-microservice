package com.powerup.propertymicroservice.commons.configuration.beans;

import com.powerup.propertymicroservice.domain.ports.in.DepartmentServicePort;
import com.powerup.propertymicroservice.domain.ports.out.DepartmentPersistencePort;
import com.powerup.propertymicroservice.domain.usecases.DepartmentUseCase;
import com.powerup.propertymicroservice.domain.utils.validations.departments.DepartmentValidator;
import com.powerup.propertymicroservice.infrastructure.adapters.persistence.DepartmentPersistenceAdapter;
import com.powerup.propertymicroservice.infrastructure.mappers.DepartmentEntityMapper;
import com.powerup.propertymicroservice.infrastructure.repositories.mysql.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DepartmentBeanConfiguration {

    private final DepartmentRepository departmentRepository;
    private final DepartmentEntityMapper departmentEntityMapper;
    
    @Bean
    public DepartmentPersistencePort departmentPersistencePort(){
        return new DepartmentPersistenceAdapter(departmentRepository,departmentEntityMapper);
    }
    
    @Bean
    public DepartmentValidator departmentValidator(){
        return new DepartmentValidator();
    }
    
    @Bean
    public DepartmentServicePort departmentServicePort(){
        return new DepartmentUseCase(departmentPersistencePort(),departmentValidator());
    }
}
