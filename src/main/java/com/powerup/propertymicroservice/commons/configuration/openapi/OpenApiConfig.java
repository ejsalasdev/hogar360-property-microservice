package com.powerup.propertymicroservice.commons.configuration.openapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Property Microservice Hogar360 API",
        version = "v1",
        description = "API para gestionar las propiedades o inmuebles"))
public class OpenApiConfig {
}
