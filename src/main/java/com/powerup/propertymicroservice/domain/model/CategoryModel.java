package com.powerup.propertymicroservice.domain.model;

import com.powerup.propertymicroservice.domain.exceptions.DescriptionMaxSizeExceededException;
import com.powerup.propertymicroservice.domain.exceptions.InvalidCategoryNameFormatException;
import com.powerup.propertymicroservice.domain.exceptions.NameMaxSizeExceededException;
import com.powerup.propertymicroservice.domain.exceptions.RequiredFieldNullOrEmptyException;
import com.powerup.propertymicroservice.domain.utils.constants.CategoryValidationConstants;
import com.powerup.propertymicroservice.domain.utils.constants.DomainConstants;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.powerup.propertymicroservice.domain.utils.constants.CategoryValidationConstants.NAME_REGEX;

public class CategoryModel {

    private Long id;
    private String name;
    private String description;

    private static final Pattern NAME_PATTERN = Pattern.compile(NAME_REGEX);

    public CategoryModel(Long id, String name, String description) {
        this.id = id;
        setName(name);
        setDescription(description);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new RequiredFieldNullOrEmptyException(DomainConstants.FIELD_NAME_NULL_MESSAGE);
        if (name.length() > CategoryValidationConstants.NAME_MAX_LENGTH)
            throw new NameMaxSizeExceededException(DomainConstants.NAME_MAX_SIZE_MESSAGE);
        if (!isValidFormatName(name))
            throw new InvalidCategoryNameFormatException(DomainConstants.INVALID_CATEGORY_NAME_FORMAT_MESSAGE);
        this.name = name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty())
            throw new RequiredFieldNullOrEmptyException(DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        if (description.length() > CategoryValidationConstants.DESCRIPTION_MAX_LENGTH)
            throw new DescriptionMaxSizeExceededException(DomainConstants.DESCRIPTION_MAX_SIZE_MESSAGE);
        this.description = description.trim();
    }

    private boolean isValidFormatName(String name) {
        Matcher matcher = NAME_PATTERN.matcher(name);
        return matcher.matches();
    }
}