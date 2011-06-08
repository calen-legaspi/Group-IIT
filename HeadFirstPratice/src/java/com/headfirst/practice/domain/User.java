package com.headfirst.practice.domain;

/**
 * Represents a user.
 * 
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
     * Reconstructor. 
     * Use this to create a new instance (from a database).
     * @param id the unique id of the user. auto-generated after database insertion.
     * @param username the username the login name.
     * @param password the password of the user.
     * @throws IllegalArgumentException if on of the parameter is null, or the id is zero.
     */
    public User(int id, String username, String password) throws IllegalArgumentException {
        this(username, password);
        if(id == 0) {
            throw new IllegalArgumentException("Id cant be null.");
        }
        this.id = id;
    }
    
    /**
     * Do not parse this result for any reason. 
     * May change after a while.
     * @return The string representation of the user.
     */
    @Override
    public String toString() {
        return username;
    }
    
    /**
     * Retrieves the auto-generated id for this user.
     * @return the id of the user.
     * @throws IllegalStateException when the id is retrieved before database insertion(when the id was not yet generated. 
     */
    public int getId() throws IllegalStateException {
        if(id == 0) {
            throw new IllegalStateException("The user id was not generated yet, please commit this to the database first.");
        }
        return id;
    }
}
