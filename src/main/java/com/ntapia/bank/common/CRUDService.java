package com.ntapia.bank.common;

import java.util.List;

public interface CRUDService<T> {

    List<T> list();

    T saveOrUpdate(T object);

    void delete(Long id);
}
