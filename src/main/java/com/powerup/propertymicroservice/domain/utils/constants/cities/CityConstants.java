package com.powerup.propertymicroservice.domain.utils.constants.cities;

public final class CityConstants {

    public static final int NAME_MAX_LENGTH = 50;
    public static final int DESCRIPTION_MAX_LENGTH = 120;
    public static final String SORT_BY_NAME = "name";
    public static final String SORT_BY_DESCRIPTION = "description";
    public static final String SORT_BY_DEPARTMENT = "department";
    public static final String DEFAULT_SORT_BY = SORT_BY_NAME;
    
    private CityConstants() {
        throw new IllegalStateException("Utility Class");
    }
}
