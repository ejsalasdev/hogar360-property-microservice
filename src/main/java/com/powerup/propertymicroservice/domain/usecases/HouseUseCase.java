package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.domain.model.CategoryModel;
import com.powerup.propertymicroservice.domain.model.HouseModel;
import com.powerup.propertymicroservice.domain.model.UbicationModel;
import com.powerup.propertymicroservice.domain.ports.in.CategoryServicePort;
import com.powerup.propertymicroservice.domain.ports.in.HouseServicePort;
import com.powerup.propertymicroservice.domain.ports.in.UbicationServicePort;
import com.powerup.propertymicroservice.domain.ports.out.HousePersistencePort;

public class HouseUseCase implements HouseServicePort {

    private final HousePersistencePort housePersistencePort;
    private final CategoryServicePort categoryServicePort;
    private final UbicationServicePort ubicationServicePort;

    public HouseUseCase(HousePersistencePort housePersistencePort, CategoryServicePort categoryServicePort, UbicationServicePort ubicationServicePort) {
        this.housePersistencePort = housePersistencePort;
        this.categoryServicePort = categoryServicePort;
        this.ubicationServicePort = ubicationServicePort;
    }

    @Override
    public void save(HouseModel houseModel, String categoryName, String ubicationName) {

        CategoryModel category = categoryServicePort.getCategoryByname(categoryName);
        UbicationModel ubication = ubicationServicePort.getUbicationByName(ubicationName);
        
        houseModel.setCategory(category);
        houseModel.setUbication(ubication);
        
        housePersistencePort.save(houseModel);      
        
    }
}
