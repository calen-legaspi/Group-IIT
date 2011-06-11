package com.onb.orderingsystem.dao.impl;

import com.onb.orderingsystem.dao.CustomerDAO;
import com.onb.orderingsystem.dao.DBConnectionFactory;
import com.onb.orderingsystem.domain.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


public class CustomerDAOimp implements CustomerDAO{

    DBConnectionFactory myFactory = DBConnectionFactory.getInstance();

    @Override
    public Customer findById(int id) {
        try{
            Connection conn = myFactory.getConnection();
            String sql = "select * from customers where id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) {
                return null;
            }
            return toCustomer(rs);
        }
	catch (SQLException e) {
           throw new RuntimeException("Error on find by ID: ",e);
	}
    }

    @Override
    public Set<Customer> getAllUnpaid() {
        try{
            Set<Customer> unpaidCustomers = new HashSet<Customer>();
            Connection conn = myFactory.getConnection();
            String sql = "select c.id, c.name from customers c, orders o where o.order_status = 'UNPAID' and c.id = o.customer_id order by c.id";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
   
            while(rs.next()){ 
                unpaidCustomers.add(toCustomer(rs));
            }
           
            return unpaidCustomers;
        }
	catch (SQLException e) {
            throw new RuntimeException("Failed to get unpaid customers", e);
	}
    }

    private Customer toCustomer(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		Customer cust = new Customer(id, name, null);
		return cust;
    } 
}
