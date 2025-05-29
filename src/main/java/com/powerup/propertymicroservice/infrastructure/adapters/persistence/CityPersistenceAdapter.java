package com.powerup.propertymicroservice.infrastructure.adapters.persistence;

import java.util.List;
import java.util.Optional;

import com.powerup.propertymicroservice.domain.model.CityModel;
import com.powerup.propertymicroservice.domain.ports.out.CityPersistencePort;
import com.powerup.propertymicroservice.infrastructure.mappers.CityEntityMapper;
import com.powerup.propertymicroservice.infrastructure.repositories.mysql.CityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CityPersistenceAdapter implements CityPersistencePort {
    
    private final CityRepository cityRepository;
    private final CityEntityMapper cityEntityMapper;

    @Override
    public Optional<CityModel> getCityByName(String name) {
        return cityRepository.findByName(name).map(cityEntityMapper::entityToModel);
    }

    @Override
    public List<CityModel> getAllCitiesByName(String name) {
        return cityRepository.findAllByName(name).stream()
                .map(cityEntityMapper::entityToModel)
                .toList();
    }

    @Override
    public Optional<CityModel> getCityAndDepartmentByName(String cityName, String departmentName) {
        return cityRepository.findByNameIgnoreCaseAndDepartment_NameIgnoreCase(cityName, departmentName).map(cityEntityMapper::entityToModel);
    }

    @Override
    public List<CityModel> findAllByDepartmentId(Long departmentId) {
        return cityRepository.findAllByDepartment_Id(departmentId).stream()
                .map(cityEntityMapper::entityToModel)
                .toList();
    }
}
