package com.fms.dao;

/**
 * Created by e7006722 on 6/03/14.
 */
public interface GenericDao<T> {
    Integer save(T entity);

    void update(T entity);

    void delete(T entity);

    T findById(int id);
}
