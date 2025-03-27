package com.powerup.propertymicroservice.infrastructure.adapters.persistence;

import com.powerup.propertymicroservice.domain.model.CityModel;
import com.powerup.propertymicroservice.domain.ports.out.CityPersistencePort;
import com.powerup.propertymicroservice.infrastructure.mappers.CityEntityMapper;
import com.powerup.propertymicroservice.infrastructure.repositories.mysql.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CityPersistenceAdapter implements CityPersistencePort {
    
    private final CityRepository cityRepository;
    private final CityEntityMapper cityEntityMapper;

    @Override
    public Optional<CityModel> getCityById(Long id) {
        return cityRepository.findById(id).map(cityEntityMapper::entityToModel);
    }

    @Override
    public Optional<CityModel> getCityByName(String name) {
        return cityRepository.findByName(name).map(cityEntityMapper::entityToModel);
    }
}
