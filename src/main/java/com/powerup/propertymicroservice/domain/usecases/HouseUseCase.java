package com.powerup.propertymicroservice.domain.usecases;

import com.powerup.propertymicroservice.commons.constants.CommonConstants;
import com.powerup.propertymicroservice.domain.enums.PublicationStatus;
import com.powerup.propertymicroservice.domain.exceptions.ElementNotFoundException;
import com.powerup.propertymicroservice.domain.model.CategoryModel;
import com.powerup.propertymicroservice.domain.model.HouseModel;
import com.powerup.propertymicroservice.domain.model.UbicationModel;
import com.powerup.propertymicroservice.domain.ports.in.CategoryServicePort;
import com.powerup.propertymicroservice.domain.ports.in.HouseServicePort;
import com.powerup.propertymicroservice.domain.ports.in.UbicationServicePort;
import com.powerup.propertymicroservice.domain.ports.out.AuthenticatedUserPort;
import com.powerup.propertymicroservice.domain.ports.out.HousePersistencePort;
import com.powerup.propertymicroservice.domain.utils.constants.houses.HousesExceptionMessagesConstants;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;
import com.powerup.propertymicroservice.domain.utils.validations.houses.HouseValidator;
import com.powerup.propertymicroservice.domain.utils.validations.pagination.PaginationValidator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

public class HouseUseCase implements HouseServicePort {

    private final HousePersistencePort housePersistencePort;
    private final CategoryServicePort categoryServicePort;
    private final UbicationServicePort ubicationServicePort;
    private final HouseValidator houseValidator;
    private final PaginationValidator paginationValidator;
    private final AuthenticatedUserPort authenticatedUserPort;

    public HouseUseCase(HousePersistencePort housePersistencePort, CategoryServicePort categoryServicePort, UbicationServicePort ubicationServicePort,
                        HouseValidator houseValidator, PaginationValidator paginationValidator, AuthenticatedUserPort authenticatedUserPort) {
        this.housePersistencePort = housePersistencePort;
        this.categoryServicePort = categoryServicePort;
        this.ubicationServicePort = ubicationServicePort;
        this.houseValidator = houseValidator;
        this.paginationValidator = paginationValidator;
        this.authenticatedUserPort = authenticatedUserPort;
    }

    @Override
    public void save(HouseModel houseModel) {
        LocalDate currentDate = LocalDate.now(ZoneId.of(CommonConstants.TIME_ZONE));

        houseValidator.validate(houseModel, currentDate);

        CategoryModel category = categoryServicePort.getCategoryById(houseModel.getCategory().getId());
        UbicationModel ubication = ubicationServicePort.getUbicationById(houseModel.getUbication().getId());

        houseModel.setCategory(category);
        houseModel.setUbication(ubication);
        houseModel.setSellerId(authenticatedUserPort.getCurrentUserId());

        if (houseModel.getActivePublicationDate().isEqual(currentDate)) {
            houseModel.setPublicationStatus(PublicationStatus.PUBLISHED);
        } else {
            houseModel.setPublicationStatus(PublicationStatus.PUBLICATION_PAUSED);
        }

        houseModel.setPublicationDate(currentDate);
        housePersistencePort.save(houseModel);
    }

    @Override
    public PageInfo<HouseModel> getHouses(
            Integer page,
            Integer size,
            String sortBy,
            Long categoryId,
            Long ubicationId,
            Integer minRooms,
            Integer maxRooms,
            Integer minBathrooms,
            Integer maxBathrooms,
            BigDecimal minPrice,
            BigDecimal maxPrice,
            boolean orderAsc
    ) {
        paginationValidator.validatePage(page);
        paginationValidator.validateSize(size);
        String sortDirection = orderAsc ? "asc" : "desc";
        return housePersistencePort.getHouses(
                page,
                size,
                sortBy,
                categoryId,
                ubicationId,
                minRooms,
                maxRooms,
                minBathrooms,
                maxBathrooms,
                minPrice,
                maxPrice,
                sortDirection
        );
    }

    @Override
    public HouseModel getHouseById(Long id) {
        Optional<HouseModel> house = housePersistencePort.getHouseById(id);
        if (house.isEmpty()){
            throw new ElementNotFoundException(String.format(
                    HousesExceptionMessagesConstants.HOUSE_NOT_FOUND, id
            ));
        }
        return house.get();
    }

    @Override
    public boolean existsByCategoryId(Long id) {
        return housePersistencePort.existByCategoryId(id);
    }
}
