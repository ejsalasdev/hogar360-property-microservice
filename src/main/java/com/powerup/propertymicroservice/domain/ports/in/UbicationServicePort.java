package com.powerup.propertymicroservice.domain.ports.in;

import com.powerup.propertymicroservice.domain.model.UbicationModel;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;

public interface UbicationServicePort {
    
    void save(UbicationModel ubicationModel, String cityName, String departmentName);
    PageInfo<UbicationModel> getUbications(String searchText, Integer page, Integer size, String sortBy, boolean orderAsc);
}
