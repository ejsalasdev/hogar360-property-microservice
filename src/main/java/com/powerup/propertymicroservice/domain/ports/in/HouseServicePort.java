package com.powerup.propertymicroservice.domain.ports.in;

import com.powerup.propertymicroservice.domain.model.HouseModel;

public interface HouseServicePort {
    
    void save(HouseModel houseModel);
}
