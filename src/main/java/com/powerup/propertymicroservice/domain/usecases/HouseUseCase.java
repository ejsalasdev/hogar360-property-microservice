package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.domain.enums.PublicationStatus;
import com.powerup.propertymicroservice.domain.model.CategoryModel;
import com.powerup.propertymicroservice.domain.model.HouseModel;
import com.powerup.propertymicroservice.domain.model.UbicationModel;
import com.powerup.propertymicroservice.domain.ports.in.CategoryServicePort;
import com.powerup.propertymicroservice.domain.ports.in.HouseServicePort;
import com.powerup.propertymicroservice.domain.ports.in.UbicationServicePort;
import com.powerup.propertymicroservice.domain.ports.out.HousePersistencePort;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class HouseUseCase implements HouseServicePort {

    private static final long MAX_DAYS_FUTURE_PUBLICATION = 30;
    private final HousePersistencePort housePersistencePort;
    private final CategoryServicePort categoryServicePort;
    private final UbicationServicePort ubicationServicePort;

    public HouseUseCase(HousePersistencePort housePersistencePort, CategoryServicePort categoryServicePort, UbicationServicePort ubicationServicePort) {
        this.housePersistencePort = housePersistencePort;
        this.categoryServicePort = categoryServicePort;
        this.ubicationServicePort = ubicationServicePort;
    }

    @Override
    public void save(HouseModel houseModel) {
        CategoryModel category = categoryServicePort.getCategoryById(houseModel.getCategory().getId());
        UbicationModel ubication = ubicationServicePort.getUbicationById(houseModel.getUbication().getId());
        
        houseModel.setCategory(category);
        houseModel.setUbication(ubication);
        
        LocalDate currentDate = LocalDate.now(ZoneId.of("America/Bogota"));
        
        if (houseModel.getActivePublicationDate().isBefore(currentDate)) {
            throw new RuntimeException("La fecha de publicacion activa no puede ser inferior a la fecha actual.");
        }

        long daysDifference = ChronoUnit.DAYS.between(currentDate, houseModel.getActivePublicationDate());

        if (daysDifference > MAX_DAYS_FUTURE_PUBLICATION) {
            throw new RuntimeException("La fecha de publicación activa no puede ser superior a " + MAX_DAYS_FUTURE_PUBLICATION + " días desde la fecha actual.");
        }

        
        if (houseModel.getActivePublicationDate().isEqual(currentDate)) {
            houseModel.setPublicationStatus(PublicationStatus.PUBLISHED);
        } else {
            houseModel.setPublicationStatus(PublicationStatus.PUBLICATION_PAUSED);
        }
        
        
        houseModel.setPublicationDate(currentDate);
        housePersistencePort.save(houseModel);
    }
}
