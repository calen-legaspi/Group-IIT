/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.headfirst.practice.dao;

import com.headfirst.practice.domain.User;

/**
 *
 * @author The Architect
 */
public interface UserDAO {
    
    void getAllUser();
    
    void findUserById(int id);
    
    void deleteUser(User user);
    
    void updateUser(User user);
    
    void createUser(User user);
}
