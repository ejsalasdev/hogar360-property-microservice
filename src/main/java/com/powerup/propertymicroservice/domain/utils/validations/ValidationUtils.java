package com.powerup.propertymicroservice.domain.utils.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ValidationUtils {

    private ValidationUtils() {
        throw new IllegalStateException("Utility Class");
    }

    public static boolean isInvalidFormat(String string, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return !matcher.matches();
    }
}