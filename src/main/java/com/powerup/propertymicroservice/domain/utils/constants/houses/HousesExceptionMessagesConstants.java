package com.powerup.propertymicroservice.domain.utils.constants.houses;

public final class HousesExceptionMessagesConstants {

    public static final String DATE_PAST_ERROR_MESSAGE = "The active publication date cannot be earlier than the current date.";
    public static final String DATE_FUTURE_LIMIT_MESSAGE = "The active publication date cannot be more than %d days from the current date.";
    public static final String MAX_LENGTH_MESSAGE = "Maximum allowed length, only %d characters maximum";
    public static final String INVALID_HOUSE_NAME_FORMAT_MESSAGE = "Name '%s' contains invalid characters. Only letters and space are allowed";
    public static final String INVALID_HOUSE_DESCRIPTION_FORMAT_MESSAGE = "Name '%s' contains invalid characters. Only letters, numbers, and space are allowed";
    public static final String NEGATIVE_INT_ERROR_MESSAGE = "Number of rooms and number of bathrooms cannot be negative";
    public static final String NOT_NULL_OR_EMPTY_ROOM_BATHROOM = "Fields numberOfRooms and numberOfBathrooms cannot be null or empty";

    public static final String NOT_NULL_OR_EMPTY_PRICE = "Field price cannot be null or empty";
    public static final String INVALID_MIN_PRICE = "Invalid price, minimum price starts from %f";
    public static final String FIELD_ADDRES_NULL_MESSAGE = "Field address cannot be null";
    public static final String FIELD_ADDRES_EMPTY_MESSAGE = "Field address cannot be empty";
    public static final String INVALID_ADDRESS_FORMAT_MESSAGE = "Address '%s' contains invalid characters. Only letters, numbers, space, and a single '#' are allowed";

    private HousesExceptionMessagesConstants() {
        throw new IllegalStateException("Utility Class");
    }
}