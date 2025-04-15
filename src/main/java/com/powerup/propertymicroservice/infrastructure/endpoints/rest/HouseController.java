package com.powerup.propertymicroservice.infrastructure.endpoints.rest;

import com.powerup.propertymicroservice.application.dto.request.SaveHouseRequest;
import com.powerup.propertymicroservice.application.dto.response.HouseResponse;
import com.powerup.propertymicroservice.application.dto.response.SaveHouseResponse;
import com.powerup.propertymicroservice.application.handler.HouseHandler;
import com.powerup.propertymicroservice.domain.utils.pagination.PageInfo;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("api/v1/house")
@RequiredArgsConstructor
@Tag(name = "House", description = "Operations related to houses")
public class HouseController {

    private final HouseHandler houseHandler;

    @PostMapping("/")
    ResponseEntity<SaveHouseResponse> save(@RequestBody @Schema(description = "House information to save") SaveHouseRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(houseHandler.save(request));
    }

    @GetMapping("/")
    public ResponseEntity<PageInfo<HouseResponse>> getAllHouses(
            @Parameter(description = "Page number (0-based)") @RequestParam(defaultValue = "0") Integer page,
            @Parameter(description = "Number of homes per page") @RequestParam(defaultValue = "10") Integer size,
            @Parameter(description = "Field to sort by (price, numberOfRooms, numberOfBathrooms, locationId, categoryId)") @RequestParam(defaultValue = "price") String sortBy,
            @Parameter(description = "Category ID for filtering homes") @RequestParam(required = false) Long categoryId,
            @Parameter(description = "Ubication ID for filtering homes") @RequestParam(required = false) Long ubicationId,
            @Parameter(description = "Minimum number of rooms") @RequestParam(required = false) Integer minRooms,
            @Parameter(description = "Maximum number of rooms") @RequestParam(required = false) Integer maxRooms,
            @Parameter(description = "Minimum number of bathrooms") @RequestParam(required = false) Integer minBathrooms,
            @Parameter(description = "Maximum number of bathrooms") @RequestParam(required = false) Integer maxBathrooms,
            @Parameter(description = "Minimum price") @RequestParam(required = false) BigDecimal minPrice,
            @Parameter(description = "Maximum price") @RequestParam(required = false) BigDecimal maxPrice,
            @Parameter(description = "Sort order (true for ascending, false for descending).") @RequestParam(defaultValue = "true") boolean orderAsc
    ) {
        PageInfo<HouseResponse> housePageInfo = houseHandler.getHouses(
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
        return ResponseEntity.ok(housePageInfo);
    }


}
