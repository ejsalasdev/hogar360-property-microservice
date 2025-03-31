package com.powerup.propertymicroservice.domain.utils.factories.ubication;

import com.powerup.propertymicroservice.domain.model.CityModel;
import com.powerup.propertymicroservice.domain.model.UbicationModel;

public class UbicationModelFactoryForTest {

    private UbicationModelFactoryForTest() {
    }

    public static UbicationModel createUbicationModel(Long id, String sector, CityModel city) {
        return new UbicationModel(id, sector, city);
    }

    public static UbicationModel createUbicationModelWithNewUbication(CityModel city) {
        return createUbicationModel(null, "SimpleSector", city);
    }

    public static UbicationModel createExistingUbicationModel(Long id, String sector, CityModel city) {
        return createUbicationModel(id, sector, city);
    }

    public static UbicationModel createNewUbicationModelWithSectorAndCity(String sector, CityModel city) {
        return createUbicationModel(null, sector, city);
    }
}
