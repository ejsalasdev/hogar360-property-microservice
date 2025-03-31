package com.powerup.propertymicroservice.domain.utils.constants.pagination;

public final class PaginationConstants {

    public static final int MAX_PAGE_SIZE = 50;
    public static final int MIN_PAGE_NUMBER = 0;
    public static final int MIN_PAGE_SIZE = 1;

    private PaginationConstants() {
        throw new IllegalStateException("Utility Class");
    }
}
