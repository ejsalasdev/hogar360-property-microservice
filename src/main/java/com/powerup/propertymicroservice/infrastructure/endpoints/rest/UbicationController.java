package com.powerup.propertymicroservice.infrastructure.endpoints.rest;

import com.powerup.propertymicroservice.application.dto.request.SaveUbicationRequest;
import com.powerup.propertymicroservice.application.dto.response.SaveUbicationResponse;
import com.powerup.propertymicroservice.application.handler.UbicationHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/ubication")
@RequiredArgsConstructor
public class UbicationController {

    private final UbicationHandler ubicationHandler;

    @PostMapping
    public ResponseEntity<SaveUbicationResponse> save(@RequestBody SaveUbicationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ubicationHandler.save(request));
    }
}
