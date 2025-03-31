package com.powerup.propertymicroservice.infrastructure.endpoints.rest;

import com.powerup.propertymicroservice.application.dto.request.SaveUbicationRequest;
import com.powerup.propertymicroservice.application.dto.response.SaveUbicationResponse;
import com.powerup.propertymicroservice.application.handler.UbicationHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Ubication", description = "Operations related to ubication")
public class UbicationController {

    private final UbicationHandler ubicationHandler;

    @Operation(summary = "Create a new ubication")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ubication created successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SaveUbicationResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data"),
            @ApiResponse(responseCode = "404", description = "Element city not found"),
            @ApiResponse(responseCode = "409", description = "Ubication already exists in the specified city"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<SaveUbicationResponse> save(@RequestBody @Schema(description = "Ubication information to save") SaveUbicationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ubicationHandler.save(request));
    }
}