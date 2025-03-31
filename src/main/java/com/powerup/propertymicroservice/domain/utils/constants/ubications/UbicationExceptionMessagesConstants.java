package com.powerup.propertymicroservice.domain.utils.constants.ubications;

public class UbicationExceptionMessagesConstants {

    public static final String UBICATION_ALREADY_EXISTS_EXCEPTION = "The ubication with sector '%s' already exists in the city '%s'.";
    public static final String UBICATION_NOT_FOUND_EXCEPTION = "No ubication was found with the name: '%s'";
    public static final String UBICATION_NAME_MAX_SIZE_MESSAGE = "The name of the ubication can not exceed 50 characters";
    public static final String INVALID_UBICATION_NAME_FORMAT_MESSAGE = "Ubication name '%s' contains invalid characters. Only letters and space are allowed.";


    private UbicationExceptionMessagesConstants() {
        throw new IllegalStateException("Utility Class");
    }
}
