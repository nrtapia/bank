package com.ntapia.bank.common;

import java.util.List;

public interface CRUDService<T> {

    List<T> list();

    T get(Long id);

    T save(T object);

    T update(T object, Long id);

    void delete(Long id);
}
