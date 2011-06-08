/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.headfirst.practice.domain;

/**
 *
 * @author lyndon
 */
public class User {
    public int id;
    private String username;
    private String password;
    
    /**
     * Minimal constructor. 
     * Use this to create a new instance of a user.
     * If you intend to retrieve an instance from a database use the other constructor.
     * @param username the login name.
     * @param password the password of the user.
     * @throws IllegalArgumentException if at least one of the argument gets a null.
     */
    public User(String username, String password) throws IllegalArgumentException {
        if(username == null || username.equals("") || password == null || password.equals("")) {
            throw new IllegalArgumentException("Password or Username can't be null.");
        }
        this.username = username;
        this.password = password;
    }
    
    /**
     * 
     * @param id
     * @param username
     * @param password
     * @throws IllegalArgumentException 
     */
    public User(int id, String username, String password) throws IllegalArgumentException {
        this(username, password);
        if(id == 0) {
            throw new IllegalArgumentException("Id cant be null.");
        }
        this.id = id;
    }
}
