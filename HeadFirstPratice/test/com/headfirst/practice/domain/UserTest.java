/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.headfirst.practice.domain;

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
    
    public UserTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        User u = new User(1, "User1", "Password1");
        
        Class c = u.getClass();
        Field[] fs = c.getDeclaredFields();
        
        /**
         * Reflection for lazy programmers.
         */
        System.out.println("Field Name: Field Value (Data Type)");
        for(Field f:fs) {    
            f.setAccessible(true);
            
            System.out.println(f.getName()+":"+f.get(u)+"("+f.getType()+")");
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
    public void testSomeMethod() {
    }
}
