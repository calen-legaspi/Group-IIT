/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.dao;

import com.onb.orderingsystem.domain.Product;
import java.util.Set;

/**
 *
 * @author juliusmercons
 */
public interface ProductDAO {
    
    public void create(Product t);
    public void update(Product t);
    public void delete(Product t);
    public Set<Product> findWhere(String sql);
    public Product findById(int id);
    public Set<Product> getAll();
    
    
    
}
