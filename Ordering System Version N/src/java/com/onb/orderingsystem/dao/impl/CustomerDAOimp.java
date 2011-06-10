package com.onb.orderingsystem.dao.impl;

import com.onb.orderingsystem.dao.CustomerDAO;
import com.onb.orderingsystem.dao.DBConnectionFactory;
import com.onb.orderingsystem.domain.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;


public class CustomerDAOimp implements CustomerDAO{

    DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
    
    @Override
    public void create(Customer t) {
        
        try{
            Connection conn = myFactory.getConnection();
            String sql = "INSERT INTO customer (name) VALUES (?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, t.getName());
            statement.executeUpdate();
            conn.close();
            statement.close();
	}catch(SQLException e){
            throw new RuntimeException("Failed to save comment");
	}
    }

    @Override
    public void update(Customer t) {
         try{
            Connection conn = myFactory.getConnection();
            String sql = "Update customer set name = ? where id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, t.getName());
            statement.setInt(2, t.getId());
            statement.executeUpdate();
            conn.close();
            statement.close();
	}catch(SQLException e){
            throw new RuntimeException("Failed to update customer");
	}
    }
    
    @Override
    public void delete(Customer t) {
         try{
            Connection conn = myFactory.getConnection();
            String sql = "DELETE customer where id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, t.getId());
            statement.executeUpdate();
            conn.close();
            statement.close();
	}catch(SQLException e){
            throw new RuntimeException("Failed to delete customer");
        }
    }

    @Override
    public Customer findById(int id) {
        try{
            Connection conn = myFactory.getConnection();
            String sql = "select * from customer where id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) {
                return null;
            }
            return read(rs);
        }
	catch (SQLException e) {
            throw new RuntimeException("Error on find by ID");
	}
    }

    @Override
    public Set<Customer> getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private Customer read(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		Customer cust = new Customer(id, name, null);
		return cust;
    }
    
}
