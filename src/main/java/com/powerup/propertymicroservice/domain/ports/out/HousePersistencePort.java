package com.powerup.propertymicroservice.domain.ports.out;

import com.powerup.propertymicroservice.domain.model.HouseModel;

import java.time.LocalDate;
import java.util.List;

public interface HousePersistencePort {

    void save(HouseModel houseModel);
    
    List<HouseModel> findHousesByActivePublicationDate(LocalDate date);
}
