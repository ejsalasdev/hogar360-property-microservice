package com.powerup.propertymicroservice.commons.configuration.beans;

import com.powerup.propertymicroservice.domain.ports.in.CategoryServicePort;
import com.powerup.propertymicroservice.domain.ports.in.HouseServicePort;
import com.powerup.propertymicroservice.domain.ports.in.UbicationServicePort;
import com.powerup.propertymicroservice.domain.ports.out.HousePersistencePort;
import com.powerup.propertymicroservice.domain.usecases.HouseUseCase;
import com.powerup.propertymicroservice.infrastructure.adapters.persistence.HousePersistenceAdapter;
import com.powerup.propertymicroservice.infrastructure.mappers.HouseEntityMapper;
import com.powerup.propertymicroservice.infrastructure.repositories.mysql.HouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class HouseBeanConfiguration {
    
    private final HouseRepository houseRepository;
    private final HouseEntityMapper houseEntityMapper;
    private final CategoryServicePort categoryServicePort;
    private final UbicationServicePort ubicationServicePort;
    
    @Bean
    public HousePersistencePort housePersistencePort() {
        return new HousePersistenceAdapter(houseRepository, houseEntityMapper);
    }
    
    @Bean
    public HouseServicePort houseServicePort() {
        return new HouseUseCase(housePersistencePort(), categoryServicePort, ubicationServicePort);
    }
}
