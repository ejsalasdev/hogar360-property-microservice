package com.powerup.propertymicroservice.infrastructure.endpoints.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cities")
@RequiredArgsConstructor
@Tag(name = "City", description = "Operations related to Cities")
public class CityController {
    
    
}
