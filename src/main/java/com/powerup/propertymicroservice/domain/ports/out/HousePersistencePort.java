package com.powerup.propertymicroservice.domain.ports.out;

import com.powerup.propertymicroservice.domain.model.HouseModel;

public interface HousePersistencePort {

    void save(HouseModel houseModel);
}
