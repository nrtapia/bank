package com.ntapia.bank.common;

import org.springframework.data.domain.Sort;

/**
 * Utility class
 */
public final class Util {

    private Util() {
    }

    private static final String FIELD_NAME = "fullName";
    public static final Sort SORT_BY_FULL_NAME = new Sort(Sort.Direction.ASC, FIELD_NAME);
    public static final String PATH_ID = "/{id}";
}
