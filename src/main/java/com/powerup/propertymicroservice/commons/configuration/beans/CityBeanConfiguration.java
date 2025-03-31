package com.powerup.propertymicroservice.commons.configuration.beans;

import com.powerup.propertymicroservice.domain.ports.in.CityServicePort;
import com.powerup.propertymicroservice.domain.ports.out.CityPersistencePort;
import com.powerup.propertymicroservice.domain.usecases.CityUseCase;
import com.powerup.propertymicroservice.domain.utils.validations.cities.CityValidator;
import com.powerup.propertymicroservice.infrastructure.adapters.persistence.CityPersistenceAdapter;
import com.powerup.propertymicroservice.infrastructure.mappers.CityEntityMapper;
import com.powerup.propertymicroservice.infrastructure.repositories.mysql.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CityBeanConfiguration {

    private final CityRepository cityRepository;
    private final CityEntityMapper cityEntityMapper;

    @Bean
    public CityPersistencePort cityPersistencePort() {
        return new CityPersistenceAdapter(cityRepository, cityEntityMapper);
    }

    @Bean
    public CityValidator cityValidator() {
        return new CityValidator();
    }

    @Bean
    public CityServicePort cityServicePort() {
        return new CityUseCase(cityPersistencePort(), cityValidator());
    }
}
