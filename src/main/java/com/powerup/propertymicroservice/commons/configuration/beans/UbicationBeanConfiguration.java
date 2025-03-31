package com.powerup.propertymicroservice.commons.configuration.beans;

import com.powerup.propertymicroservice.domain.ports.in.UbicationServicePort;
import com.powerup.propertymicroservice.domain.ports.out.UbicationPersistencePort;
import com.powerup.propertymicroservice.domain.usecases.UbicationUseCase;
import com.powerup.propertymicroservice.domain.utils.validations.ubications.UbicationValidator;
import com.powerup.propertymicroservice.infrastructure.adapters.persistence.UbicationPersistenceAdapter;
import com.powerup.propertymicroservice.infrastructure.mappers.UbicationEntityMapper;
import com.powerup.propertymicroservice.infrastructure.repositories.mysql.UbicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UbicationBeanConfiguration {

    private final UbicationRepository ubicationRepository;
    private final UbicationEntityMapper ubicationEntityMapper;
    private final CityBeanConfiguration cityBeanConfiguration;

    @Bean
    public UbicationPersistencePort ubicationPersistencePort() {
        return new UbicationPersistenceAdapter(ubicationRepository, ubicationEntityMapper);
    }
    
    @Bean
    public UbicationValidator ubicationValidator() {
        return new UbicationValidator();
    }

    @Bean
    public UbicationServicePort ubicationServicePort() {
        return new UbicationUseCase(ubicationPersistencePort(), cityBeanConfiguration.cityServicePort(), ubicationValidator());
    }
}
