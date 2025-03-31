package com.powerup.propertymicroservice.infrastructure.adapters.persistence;

import com.powerup.propertymicroservice.domain.model.UbicationModel;
import com.powerup.propertymicroservice.domain.ports.out.UbicationPersistencePort;
import com.powerup.propertymicroservice.infrastructure.entities.UbicationEntity;
import com.powerup.propertymicroservice.infrastructure.mappers.UbicationEntityMapper;
import com.powerup.propertymicroservice.infrastructure.repositories.mysql.UbicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UbicationPersistenceAdapter implements UbicationPersistencePort {

    private final UbicationRepository ubicationRepository;
    private final UbicationEntityMapper ubicationEntityMapper;

    @Override
    public void save(UbicationModel ubicationModel) {
        UbicationEntity ubicationEntity = ubicationEntityMapper.modelToEntity(ubicationModel);
        ubicationRepository.save(ubicationEntity);
    }

    @Override
    public Optional<UbicationModel> getUbicationBySectorAndCityId(String sector, Long cityId) {
        return ubicationRepository.findBySectorAndCityId(sector, cityId)
                .map(ubicationEntityMapper::entityToModel);
    }
}
