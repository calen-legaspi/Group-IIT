/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.headfirst.practice.domain;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.lang.reflect.Field;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lyndon
 */
public class UserTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
        User u = new User(1, "User1", "Password1");

        Class c = u.getClass();
        Field[] fs = c.getDeclaredFields();

        /**
         * Reflection for lazy programmers.
         */
        System.out.println("Field Name: Field Value (Data Type)");
        for (Field f : fs) {
            f.setAccessible(true);
            System.out.println(f.getName() + ":" + f.get(u) + "(" + f.getType() + ")");
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver class not found in classpath");
            //handle exception here
        }


        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test", "root", "password");

        pstmt = con.prepareStatement(
                "INSERT INTO testing(name) VALUES(?)");
        pstmt.setString(1, "Waahhahahahahha");
        
        pstmt.executeUpdate();

    }
}
