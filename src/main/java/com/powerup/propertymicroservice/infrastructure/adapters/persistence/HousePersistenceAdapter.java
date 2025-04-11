package com.powerup.propertymicroservice.infrastructure.adapters.persistence;

import com.powerup.propertymicroservice.domain.model.HouseModel;
import com.powerup.propertymicroservice.domain.ports.out.HousePersistencePort;
import com.powerup.propertymicroservice.infrastructure.entities.HouseEntity;
import com.powerup.propertymicroservice.infrastructure.mappers.HouseEntityMapper;
import com.powerup.propertymicroservice.infrastructure.repositories.mysql.HouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class HousePersistenceAdapter implements HousePersistencePort {
    
    private final HouseRepository houseRepository;
    private final HouseEntityMapper houseEntityMapper;
    @Override
    public void save(HouseModel houseModel) {
        HouseEntity houseEntity = houseEntityMapper.modelToEntity(houseModel);
        houseRepository.save(houseEntity);
    }

    @Override
    public List<HouseModel> findHousesByActivePublicationDate(LocalDate date) {
        List<HouseEntity> houseEntities = houseRepository.findByActivePublicationDate(date);
        return houseEntities.stream()
                .map(houseEntityMapper::entityToModel)
                .toList();
    }
}
