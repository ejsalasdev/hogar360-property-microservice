package com.powerup.propertymicroservice.infrastructure.exceptionshandler;

public class ExceptionConstants {

    private ExceptionConstants(){}

    public static final String NAME_MAX_SIZE_MESSAGE = "The name of the category can not exceed 50 characters";
    public static final String DESCRIPTION_MAX_SIZE_MESSAGE = "The description of the category can not exceed 90 characters";
    public static final String CATEGORY_EXISTS_EXCEPTION = "The category already exists";
    public static final String REQUIRED_FIELD_MESSAGE = "Field can't null or empty";


}
