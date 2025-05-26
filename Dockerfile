# Multi-stage build para optimizar el tamaño de la imagen
FROM openjdk:17-jdk-slim AS builder

# Establecer directorio de trabajo
WORKDIR /app

# Copiar archivos de configuración de Gradle
COPY gradle/ gradle/
COPY gradlew build.gradle settings.gradle ./

# Hacer ejecutable el wrapper de Gradle
RUN chmod +x ./gradlew

# Copiar código fuente
COPY src/ src/

# Construir la aplicación
RUN ./gradlew build -x test

# Imagen final
FROM openjdk:17-jre-slim

# Crear usuario no-root para seguridad
RUN addgroup --system spring && adduser --system spring --ingroup spring

# Establecer directorio de trabajo
WORKDIR /app

# Copiar el JAR desde el stage de construcción
COPY --from=builder /app/build/libs/*.jar app.jar

# Cambiar propietario del archivo
RUN chown spring:spring app.jar

# Cambiar a usuario no-root
USER spring

# Exponer puerto
EXPOSE 8081

# Health check
HEALTHCHECK --interval=30s --timeout=3s --start-period=60s --retries=3 \
  CMD ["sh", "-c", "curl -f http://localhost:8081/actuator/health || exit 1"]

# Comando de inicio
ENTRYPOINT ["java", "-jar", "app.jar"]