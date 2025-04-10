package com.powerup.propertymicroservice.infrastructure.endpoints.rest;

import com.powerup.propertymicroservice.application.dto.request.SaveHouseRequest;
import com.powerup.propertymicroservice.application.dto.response.SaveHouseResponse;
import com.powerup.propertymicroservice.application.handler.HouseHandler;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/house")
@RequiredArgsConstructor
@Tag(name = "House", description = "Operations related to houses")
public class HouseController {
    
    private final HouseHandler houseHandler;
    
    @PostMapping("/")
    ResponseEntity<SaveHouseResponse> save(@RequestBody @Schema(description = "House information to save")SaveHouseRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(houseHandler.save(request));
    }
}
