package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.commons.constants.CommonConstants;
import com.powerup.propertymicroservice.domain.enums.PublicationStatus;
import com.powerup.propertymicroservice.domain.model.CategoryModel;
import com.powerup.propertymicroservice.domain.model.HouseModel;
import com.powerup.propertymicroservice.domain.model.UbicationModel;
import com.powerup.propertymicroservice.domain.ports.in.CategoryServicePort;
import com.powerup.propertymicroservice.domain.ports.in.HouseServicePort;
import com.powerup.propertymicroservice.domain.ports.in.UbicationServicePort;
import com.powerup.propertymicroservice.domain.ports.out.HousePersistencePort;
import com.powerup.propertymicroservice.domain.utils.validations.houses.HouseValidator;

import java.time.LocalDate;
import java.time.ZoneId;

public class HouseUseCase implements HouseServicePort {
    
    private final HousePersistencePort housePersistencePort;
    private final CategoryServicePort categoryServicePort;
    private final UbicationServicePort ubicationServicePort;
    private final HouseValidator houseValidator;

    public HouseUseCase(HousePersistencePort housePersistencePort, CategoryServicePort categoryServicePort, UbicationServicePort ubicationServicePort, HouseValidator houseValidator) {
        this.housePersistencePort = housePersistencePort;
        this.categoryServicePort = categoryServicePort;
        this.ubicationServicePort = ubicationServicePort;
        this.houseValidator = houseValidator;
    }

    @Override
    public void save(HouseModel houseModel) {
        CategoryModel category = categoryServicePort.getCategoryById(houseModel.getCategory().getId());
        UbicationModel ubication = ubicationServicePort.getUbicationById(houseModel.getUbication().getId());
        
        houseModel.setCategory(category);
        houseModel.setUbication(ubication);
        
        LocalDate currentDate = LocalDate.now(ZoneId.of(CommonConstants.TIME_ZONE));
        
        houseValidator.validatePublicationDate(houseModel.getActivePublicationDate(), currentDate);
        
        if (houseModel.getActivePublicationDate().isEqual(currentDate)) {
            houseModel.setPublicationStatus(PublicationStatus.PUBLISHED);
        } else {
            houseModel.setPublicationStatus(PublicationStatus.PUBLICATION_PAUSED);
        }
        
        houseModel.setPublicationDate(currentDate);
        housePersistencePort.save(houseModel);
    }
}
