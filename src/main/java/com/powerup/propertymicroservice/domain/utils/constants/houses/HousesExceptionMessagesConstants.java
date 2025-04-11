package com.powerup.propertymicroservice.domain.utils.constants.houses;

public final class HousesExceptionMessagesConstants {
    
    public static final String DATE_PAST_ERROR_MESSAGE = "La fecha de publicacion activa no puede ser inferior a la fecha actual.";
    public static final String DATE_FUTURE_LIMIT_MESSAGE = "La fecha de publicación activa no puede ser superior a %d días desde la fecha actual.";

    private HousesExceptionMessagesConstants() {
        throw new IllegalStateException("Utility Class");
    }
}
