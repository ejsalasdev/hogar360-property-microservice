package com.powerup.propertymicroservice.domain.utils.constants.houses;

import java.math.BigDecimal;

public final class HouseConstants {

    public static final long MAX_DAYS_FUTURE_PUBLICATION = 30;
    public static final long NAME_MAX_LENGTH = 50;
    public static final long DESCRIPTION_MAX_LENGTH = 300;
    public static final BigDecimal MIN_PRICE = new BigDecimal("0");
    public static final String STRING_ONLY_VALID_FORMAT_REGEX = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";
    public static final String STRING_ALPHANUMERIC_VALID_FORMAT_REGEX = "^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s]+$";
    public static final String STRING_ALPHANUMERIC_ADDRESS_VALID_FORMAT_REGEX = "^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s]*#?[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s]*$";

    private HouseConstants() {
        throw new IllegalStateException("Utility Class");
    }
}
