package com.powerup.propertymicroservice.commons.configuration.beans;

import com.powerup.propertymicroservice.domain.ports.in.CityServicePort;
import com.powerup.propertymicroservice.domain.ports.in.UbicationServicePort;
import com.powerup.propertymicroservice.domain.ports.out.UbicationPersistencePort;
import com.powerup.propertymicroservice.domain.usecases.UbicationUseCase;
import com.powerup.propertymicroservice.domain.utils.validations.pagination.PaginationValidator;
import com.powerup.propertymicroservice.domain.utils.validations.ubications.UbicationValidator;
import com.powerup.propertymicroservice.infrastructure.adapters.persistence.UbicationPersistenceAdapter;
import com.powerup.propertymicroservice.infrastructure.mappers.UbicationEntityMapper;
import com.powerup.propertymicroservice.infrastructure.repositories.mysql.UbicationRepository;
import com.powerup.propertymicroservice.infrastructure.utils.sort.UbicationSortHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UbicationBeanConfiguration {

    private final UbicationRepository ubicationRepository;
    private final UbicationEntityMapper ubicationEntityMapper;
    private final UbicationSortHelper ubicationSortHelper;

    @Bean
    public UbicationPersistencePort ubicationPersistencePort() {
        return new UbicationPersistenceAdapter(ubicationRepository, ubicationEntityMapper, ubicationSortHelper);
    }

    @Bean
    public UbicationValidator ubicationValidator() {
        return new UbicationValidator();
    }

    @Bean
    public UbicationServicePort ubicationServicePort(
            UbicationPersistencePort ubicationPersistencePort,
            CityServicePort cityServicePort,
            UbicationValidator ubicationValidator,
            PaginationValidator paginationValidator
    ) {
        return new UbicationUseCase(
                ubicationPersistencePort,
                cityServicePort,
                ubicationValidator,
                paginationValidator
        );
    }
}
