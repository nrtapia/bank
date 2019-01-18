package com.ntapia.bank.common;

import org.springframework.data.domain.Sort;

/**
 *
 */
public final class Util {

    private Util() {
    }

    private static final String FIELD_NAME = "fullName";
    public static final Sort DEFAULT_SORT = new Sort(Sort.Direction.ASC, FIELD_NAME);

    public static final String PATH_ID = "/{id}";
}
