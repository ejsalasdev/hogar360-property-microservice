package com.powerup.propertymicroservice.commons.configuration.beans;

import com.powerup.propertymicroservice.domain.ports.in.CategoryServicePort;
import com.powerup.propertymicroservice.domain.ports.in.HouseServicePort;
import com.powerup.propertymicroservice.domain.ports.in.UbicationServicePort;
import com.powerup.propertymicroservice.domain.ports.out.HousePersistencePort;
import com.powerup.propertymicroservice.domain.usecases.HouseUseCase;
import com.powerup.propertymicroservice.domain.utils.validations.houses.HouseValidator;
import com.powerup.propertymicroservice.domain.utils.validations.pagination.PaginationValidator;
import com.powerup.propertymicroservice.infrastructure.adapters.persistence.HousePersistenceAdapter;
import com.powerup.propertymicroservice.infrastructure.mappers.HouseEntityMapper;
import com.powerup.propertymicroservice.infrastructure.repositories.mysql.HouseRepository;
import com.powerup.propertymicroservice.infrastructure.utils.sort.HouseSortHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class HouseBeanConfiguration {

    private final HouseRepository houseRepository;
    private final HouseEntityMapper houseEntityMapper;
    private final HouseSortHelper houseSortHelper;

    @Bean
    public HousePersistencePort housePersistencePort() {
        return new HousePersistenceAdapter(houseRepository, houseEntityMapper, houseSortHelper);
    }

    @Bean
    public HouseValidator houseValidator() {
        return new HouseValidator();
    }

    @Bean
    public HouseServicePort houseServicePort(
            HousePersistencePort housePersistencePort,
            CategoryServicePort categoryServicePort,
            UbicationServicePort ubicationServicePort,
            HouseValidator houseValidator,
            PaginationValidator paginationValidator
    ) {
        return new HouseUseCase(
                housePersistencePort,
                categoryServicePort,
                ubicationServicePort,
                houseValidator,
                paginationValidator
        );
    }
}
