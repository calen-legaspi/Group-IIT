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
import com.mysql.jdbc.*;

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


        con = DriverManager.getConnection("jdbc:mysql:localhost", "root", "password");

        pstmt = con.prepareStatement(
                "UPDATE EMPLOYEES SET CAR_NUMBER = ? "
                + "WHERE EMPLOYEE_NUMBER = ?");
        pstmt.setInt(1, 1);
        pstmt.setInt(2, 2);
        pstmt.executeUpdate();

    }
}
