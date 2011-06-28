/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.dao.impl;

import static org.junit.Assert.assertEquals;
import com.onb.orderingsystem.dao.*;
import com.onb.orderingsystem.domain.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.junit.Test;
/**
 *
 * @author juliusmercons
 */
public class testCustomerDAO {
	
	protected IDatabaseConnection getConnection() {
            try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection jdbcConnection = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1/OrderingSystem?user=root&password=qwerty");
		return new DatabaseConnection(jdbcConnection);
	}catch(Exception e){
            System.out.println(e);
            return null;
        }
        }
        
        @Test
	public void testGetUnpaidCustomers() {
	
		try{
		CustomerDAO dao = new CustomerDAOimp();
		Set<Customer> customer = dao.getAllUnpaid();

		QueryDataSet expectedDataSet = new QueryDataSet(getConnection());
		expectedDataSet.addTable("customers","select c.id, c.name from customers c, orders o where o.order_status = 'UNPAID' and c.id = o.customer_id order by c.id");
		
                Set<Customer> expected_customers = new HashSet<Customer>();
                
                Customer expected_customer = new Customer((Integer)expectedDataSet.getTable("customers").getValue(0, "id"), (String)expectedDataSet.getTable("customers").getValue(0, "name"), null);
                //expected_customers.clear();
                expected_customers.add(expected_customer);
		//expected_customers.add(new Customer(2, "asd", null));
                
		assertEquals(expected_customers,customer);
                }catch(Exception e){
                    System.out.println(e);
                }
	}
}
