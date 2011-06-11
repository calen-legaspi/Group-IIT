/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.dao;

import java.sql.Connection;

/**
 *
 * @author juliusmercons
 */
public abstract class DBConnectionFactory {
    
     public static DBConnectionFactoryImpl getInstance(){
        String driver,url,username,password;
        driver= "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://127.0.0.1/OrderingSystem";
        username = "root";
        password = "qwerty";
        return new DBConnectionFactoryImpl(driver,url,username,password);
    }

    public abstract Connection getConnection();
}
