package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.domain.exceptions.ElementAlreadyExistsException;
import com.powerup.propertymicroservice.domain.exceptions.ElementNotFoundException;
import com.powerup.propertymicroservice.domain.model.CityModel;
import com.powerup.propertymicroservice.domain.model.UbicationModel;
import com.powerup.propertymicroservice.domain.ports.in.CityServicePort;
import com.powerup.propertymicroservice.domain.ports.in.UbicationServicePort;
import com.powerup.propertymicroservice.domain.ports.out.UbicationPersistencePort;
import com.powerup.propertymicroservice.domain.utils.constants.ubications.UbicationExceptionMessagesConstants;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;
import com.powerup.propertymicroservice.domain.utils.validations.pagination.PaginationValidator;
import com.powerup.propertymicroservice.domain.utils.validations.ubications.UbicationValidator;

import java.util.Optional;


public class UbicationUseCase implements UbicationServicePort {

    private final UbicationPersistencePort ubicationPersistencePort;
    private final CityServicePort cityServicePort;
    private final UbicationValidator ubicationValidator;
    private final PaginationValidator paginationValidator;

    public UbicationUseCase(UbicationPersistencePort ubicationPersistencePort, CityServicePort cityServicePort, UbicationValidator ubicationValidator, PaginationValidator paginationValidator) {
        this.ubicationPersistencePort = ubicationPersistencePort;
        this.cityServicePort = cityServicePort;
        this.ubicationValidator = ubicationValidator;
        this.paginationValidator = paginationValidator;
    }

    @Override
    public void save(UbicationModel ubicationModel, String cityName, String departmentName) {
        ubicationValidator.validateSectorName(ubicationModel.getSector());

        CityModel city;

        if (departmentName == null || departmentName.trim().isEmpty()) {
            city = cityServicePort.getUniqueCityByName(cityName);
        } else {
            city = cityServicePort.getCityByNameAndDepartmentName(cityName, departmentName);
        }


        Optional<UbicationModel> existingUbication = ubicationPersistencePort
                .getUbicationBySectorAndCityId(ubicationModel.getSector(), city.getId());

        if (existingUbication.isPresent()) {
            throw new ElementAlreadyExistsException(
                    String.format(UbicationExceptionMessagesConstants.UBICATION_ALREADY_EXISTS_EXCEPTION, ubicationModel.getSector(), cityName)
            );
        }

        ubicationModel.setCity(city);
        ubicationPersistencePort.save(ubicationModel);
    }

    @Override
    public PageInfo<UbicationModel> getUbications(String searchText, Integer page, Integer size, String sortBy, boolean orderAsc) {
        paginationValidator.validatePage(page);
        paginationValidator.validatePage(size);
        String sortDirection = orderAsc ? "asc" : "desc";
        return ubicationPersistencePort.getUbications(searchText, page, size, sortBy, sortDirection);
    }

    @Override
    public UbicationModel getUbicationByName(String ubicationName) {
        Optional<UbicationModel> ubication = ubicationPersistencePort.getCategoryByname(ubicationName);
        if (ubication.isEmpty()) {
            throw new ElementNotFoundException(
                    String.format(UbicationExceptionMessagesConstants.UBICATION_NOT_FOUND_EXCEPTION, ubicationName)
            );
        }
        return ubication.get();
    }
}
