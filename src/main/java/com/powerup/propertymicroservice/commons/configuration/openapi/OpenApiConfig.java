package com.powerup.propertymicroservice.commons.configuration.openapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Property Microservice - Hogar360 API",
        version = "v1.0.0",
        description = """
            API para gestionar las propiedades e inmuebles del sistema Hogar360.
            
            Permite realizar operaciones CRUD sobre:
            - Casas/Propiedades con filtros por categoria, ubicación y vendedor
            - Categorías de propiedades (apartamentos, casas, etc.)
            - Ubicaciones (sectores, ciudades y departamentos)
            
            **Roles de usuario:**
            - ADMIN: Acceso completo a todas las propiedades
            - SELLER: Solo puede ver y gestionar sus propias propiedades
            - Usuario no autenticado: Solo puede ver propiedades publicadas
            """,
        contact = @Contact(
            name = "Hogar360 Development Team",
            email = "dev@hogar360.com"
        ),
        license = @License(
            name = "MIT License",
            url = "https://opensource.org/licenses/MIT"
        )
    ),
    servers = {
        @Server(
            url = "http://localhost:8081",
            description = "Development Server"
        ),
        @Server(
            url = "https://property.hogar360.site",
            description = "Production Server"
        )
    }
)
@SecurityScheme(
    name = "bearerAuth",
    type = SecuritySchemeType.HTTP,
    scheme = "bearer",
    bearerFormat = "JWT",
    description = "JWT Bearer token authentication. Obtén el token del servicio de autenticación."
)
public class OpenApiConfig {
}
