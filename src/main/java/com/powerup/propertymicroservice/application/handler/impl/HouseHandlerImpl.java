package com.powerup.propertymicroservice.application.handler.impl;

import com.powerup.propertymicroservice.application.dto.request.SaveHouseRequest;
import com.powerup.propertymicroservice.application.dto.response.HouseResponse;
import com.powerup.propertymicroservice.application.dto.response.SaveHouseResponse;
import com.powerup.propertymicroservice.application.handler.HouseHandler;
import com.powerup.propertymicroservice.application.mappers.HouseRequestMapper;
import com.powerup.propertymicroservice.application.mappers.HouseResponseMapper;
import com.powerup.propertymicroservice.application.utils.constants.ApplicationConstants;
import com.powerup.propertymicroservice.domain.model.HouseModel;
import com.powerup.propertymicroservice.domain.ports.in.HouseServicePort;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HouseHandlerImpl implements HouseHandler {

    private final HouseServicePort houseServicePort;
    private final HouseRequestMapper houseRequestMapper;
    private final HouseResponseMapper houseResponseMapper;

    @Override
    public SaveHouseResponse save(SaveHouseRequest request) {
        houseServicePort.save(houseRequestMapper.requestToModel(request));
        return new SaveHouseResponse(ApplicationConstants.SAVE_HOUSE_RESPONSE_MESSAGE, LocalDateTime.now());
    }

    @Override
    public PageInfo<HouseResponse> getHouses(
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
        PageInfo<HouseModel> housePageInfo = houseServicePort.getHouses(
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
                orderAsc
        );
        List<HouseResponse> housesResponses = housePageInfo.getContent().stream()
                .map(houseResponseMapper::modelToResponse)
                .toList();

        return new PageInfo<>(
                housesResponses,
                housePageInfo.getTotalElements(),
                housePageInfo.getTotalPages(),
                housePageInfo.getCurrentPage(),
                housePageInfo.getPageSize(),
                housePageInfo.isHasNext(),
                housePageInfo.isHasPrevious()
        );
    }
}
