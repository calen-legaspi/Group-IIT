package com.onb.orderingsystem.dao;

import java.util.Set;

/**
 * Basic DAO
 * 
 */
public interface DAO<T> {
    /**
     * 
     * @param t 
     */
    public void create(T t);
    
    /**
     * 
     * @param t 
     */
    public void update(T t);
    
    /**
     * 
     * @param t 
     */
    public void delete(T t);
    
    /**
     * 
     * @param id
     * @return 
     */
    public T findById(int id);
    
    /**
     * 
     * @param whereStatement
     * @return 
     */
    public T findWhere(String whereStatement);
    
    /**
     * 
     * @return 
     */
    public Set<T> getAll();
}
