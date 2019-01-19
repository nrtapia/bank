package com.ntapia.bank.common;

import java.util.List;

/**
 * Contract to CRUD services
 *
 * @param <T>
 */
public interface CRUDService<T> {

    /**
     * Return all records
     *
     * @return list data
     */
    List<T> list();

    /**
     * Get a record by id
     *
     * @param id
     *         unique record identifier
     * @return a record
     */
    T get(Long id);

    /**
     * Persist record data
     *
     * @param object
     *         new object data
     * @return record persisted
     */
    T save(T object);

    /**
     * Update record data
     *
     * @param object
     *         new data to update
     * @param id
     *         unique record identifier
     * @return record updated
     */
    T update(T object, Long id);

    /**
     * Delete record
     *
     * @param id
     *         unique record identifier
     */
    void delete(Long id);
}
