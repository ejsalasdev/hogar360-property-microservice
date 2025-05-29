# 🏠 Property Microservice

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://openjdk.java.net/projects/jdk/17/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.3-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)](https://www.mysql.com/)
[![JWT](https://img.shields.io/badge/JWT-Auth0-purple.svg)](https://auth0.com/)
[![CI/CD](https://img.shields.io/badge/CI%2FCD-GitHub%20Actions-blue.svg)](https://github.com/features/actions)
[![Docker](https://img.shields.io/badge/Docker-Hub-blue.svg)](https://hub.docker.com/)

Microservicio de gestión de propiedades inmobiliarias que implementa **Arquitectura Hexagonal** y **Domain-Driven Design (DDD)** para el manejo de casas, categorías y ubicaciones. Parte del ecosistema **Hogar360** con APIs REST seguras y autenticación JWT.

## 🎯 Características Principales

- ✅ **Gestión de Propiedades**: CRUD completo de casas, categorías y ubicaciones
- ✅ **Arquitectura Hexagonal + DDD**: Dominio puro, puertos/adaptadores y modelos
- ✅ **Seguridad JWT**: Autenticación y autorización con Auth0
- ✅ **Persistencia MySQL**: JPA/Hibernate con consultas optimizadas
- ✅ **Testing Robusto**: Cobertura completa en el dominio con JUnit 5 + Mockito 5.15.2
- ✅ **Documentación API**: OpenAPI 3 con Swagger UI
- ✅ **CI/CD Pipeline**: GitHub Actions con Docker Hub para despliegue automático

## 🏗️ Arquitectura

### Principios de Diseño
- **Domain-Driven Design (DDD)**: Modelos de dominio ricos, casos de uso bien definidos
- **Arquitectura Hexagonal**: Separación clara entre dominio, aplicación e infraestructura
- **Puertos y Adaptadores**: Interfaces que definen contratos entre capas
- **Casos de Uso**: Orquestación de la lógica de negocio

### Estructura del Proyecto
```
src/main/java/com/powerup/propertymicroservice/
├── domain/                     # Capa de Dominio (DDD Core)
│   ├── model/                  # Modelos de dominio
│   ├── usecases/               # Casos de uso (lógica de negocio)
│   ├── ports/                  # Puertos (interfaces)
│   └── utils/validations/      # Validadores de dominio
├── application/                # Capa de Aplicación
│   ├── dto/                    # Data Transfer Objects
│   └── handler/                # Handlers de casos de uso
├── infrastructure/             # Capa de Infraestructura
│   ├── adapters/persistence/   # Adaptadores de persistencia
│   ├── entities/               # Entidades JPA
│   ├── repositories/mysql/     # Repositorios MySQL
│   └── security/jwt/           # Implementación JWT
└── commons/                    # Configuración y constantes
```

## 🛠️ Stack Tecnológico

### Backend
- **Java 17** - Versión LTS con características modernas
- **Spring Boot 3.4.3** - Framework principal
- **Spring Security** - Seguridad y autenticación
- **Spring Data JPA** - Persistencia de datos

### Base de Datos
- **MySQL** - Base de datos principal en producción

### Herramientas
- **MapStruct 1.6.3** - Mapeo automático entre objetos
- **Lombok** - Reducción de código boilerplate
- **JUnit 5 + Mockito 5.15.2** - Testing unitario
- **JaCoCo** - Cobertura de código
- **SpringDoc OpenAPI 2.8.5** - Documentación automática

### DevOps & CI/CD
- **GitHub Actions** - Pipeline de integración y despliegue continuo
- **Docker** - Containerización de la aplicación
- **Docker Hub** - Registro de imágenes de contenedor
- **MySQL en CI** - Testing con base de datos real en pipeline

## 🔐 Seguridad JWT

### Roles del Sistema
- **ADMIN**: Acceso completo a categorías y todas las propiedades
- **SELLER**: Gestión de propiedades propias
- **Público**: Consulta de propiedades publicadas

### Configuración
```java
jwt:
  secret: ${JWT_SECRET}
  user: ${JWT_USER:AUTH0JWT_BACKEND}
  expiration: ${JWT_EXPIRATION:86400000}
```

## 📋 Funcionalidades

### 🏠 Gestión de Propiedades
- **Estados**: `PUBLISHED`, `PUBLICATION_PAUSED`
- **Validaciones**: Nombre, descripción, precio, dirección, habitaciones, baños
- **Filtrado**: Por categoría, ubicación, precio
- **Paginación**: Configurada con validadores

### 🏢 Gestión de Categorías
- **CRUD completo** para administradores
- **Validación de uso**: No permite eliminar categorías en uso
- **Validaciones**: Nombre único, formato alfabético

### 📍 Sistema de Ubicaciones
```
Departamento (33 departamentos colombianos)
    └── Ciudad (113 ciudades principales)
        └── Sector (definido por usuarios)
```

## 🧪 Testing

### Estrategia de Testing Unitario
El proyecto implementa **únicamente tests unitarios** con cobertura completa:

#### Tests de Casos de Uso
- `CategoryUseCaseTest` - Validaciones CRUD de categorías
- `HouseUseCaseTest` - Lógica completa de propiedades con roles
- `UbicationUseCaseTest` - Gestión de ubicaciones y sectores
- `CityUseCaseTest` - Operaciones con ciudades y departamentos
- `DepartmentUseCaseTest` - Gestión de departamentos

#### Tests de Validadores
- `HouseValidatorTest` - Validaciones de campos de propiedades
- `CategoryValidatorTest` - Validaciones de categorías
- `UbicationValidatorTest` - Validaciones de sectores
- `PaginationValidatorTest` - Validaciones de paginación

#### Configuración JaCoCo
```gradle
jacocoTestReport {
    reports {
        html.required = true
        xml.required = true
        csv.required = true
    }
}
```

## 🚀 Instalación y Configuración

### Prerrequisitos
- **Java 17+**
- **MySQL 8.0+**
- **Gradle 7.0+**

### 1. Base de Datos
```sql
CREATE DATABASE hogar360_property_db;
```

### 2. Variables de Entorno
```bash
DB_HOST=localhost
DB_PORT=3306
DB_NAME=hogar360_property_db
DB_USERNAME=root
DB_PASSWORD=toor
JWT_SECRET=your-secret-key
SERVER_PORT=8081
```

### 3. Ejecución
```bash
# Desarrollo
./gradlew bootRun

# Tests
./gradlew test

# Construcción
./gradlew build
```

## 📖 Documentación de API

### Swagger UI
- **URL**: `http://localhost:8081/swagger-ui/index.html`
- **OpenAPI JSON**: `http://localhost:8081/v3/api-docs`

### Endpoints Principales
```http
# Houses
GET    /api/v1/house/list              # Listar propiedades (público)
POST   /api/v1/house/create            # Crear propiedad (SELLER+)

# Categories  
GET    /api/v1/category/list           # Listar categorías (público)
POST   /api/v1/category/create         # Crear categoría (ADMIN)

# Locations
GET    /api/v1/ubication/list          # Listar ubicaciones (público)
GET    /api/v1/department/list         # Listar departamentos (público)
GET    /api/v1/city/list              # Listar ciudades (público)
```

### Filtros de Búsqueda
- `page`: Número de página (0-based)
- `size`: Tamaño de página (1-50)
- `sortBy`: Campo de ordenamiento
- `orderAsc`: Dirección de ordenamiento
- `categoryId`: Filtro por categoría
- `locationText`: Filtro por ubicación

## 🌐 Despliegue

### CI/CD Pipeline con GitHub Actions
El proyecto implementa un pipeline completo de **CI/CD** con las siguientes características:

#### 🔄 Flujo Automatizado
- **Trigger**: Push a branch `develop`
- **Testing**: Ejecuta tests con MySQL 8 en contenedor
- **Build**: Construcción automática con Gradle
- **Docker**: Creación y push automático de imágenes
- **Registry**: Docker Hub como repositorio de imágenes

#### ⚙️ Configuración del Pipeline
```yaml
# .github/workflows/deploy.yml
- Build y tests con MySQL 8 en GitHub Actions
- Cache de dependencias Gradle
- Construcción de imagen Docker multi-platform
- Push automático a Docker Hub con tags:
  - latest (última versión)
  - SHA del commit (versionado específico)
```

#### 🐳 Docker Hub
```bash
# Imágenes disponibles
docker pull $DOCKERHUB_USERNAME/property-microservice:latest
docker pull $DOCKERHUB_USERNAME/property-microservice:$COMMIT_SHA
```

### Configuración CORS
```java
// URLs permitidas
"http://localhost:4200"           // Desarrollo
"https://property.hogar360.site"  // Producción
"http://property.hogar360.site"   // Producción
```
```

## 🤝 Contribución

1. Fork del repositorio
2. Crear branch: `git checkout -b feature/nueva-funcionalidad`
3. Implementar con tests unitarios
4. Verificar cobertura de código
5. Crear Pull Request

---

**Desarrollado con ❤️ utilizando Spring Boot, DDD y Arquitectura Hexagonal**
