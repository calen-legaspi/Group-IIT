package com.onb.orderingsystem.dao;

import java.util.Set;

/**
 * Basic DAO
 * 
 */
public interface DAO<T> {
    public void create(T t);
    public void update(T t);
    public void delete(T t);
    public T findById(int id);
    public Set<T> getAll();
}
