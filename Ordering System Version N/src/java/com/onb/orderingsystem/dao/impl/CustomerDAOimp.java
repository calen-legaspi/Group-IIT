package com.onb.orderingsystem.dao.impl;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.onb.orderingsystem.dao.CustomerDAO;
import com.onb.orderingsystem.dao.DBConnectionFactory;
import com.onb.orderingsystem.domain.Customer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

/**
 *
 * @author juliusmercons
 */
public class CustomerDAOimp implements CustomerDAO{

    DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
    public void create(Customer t) {
       try{
           Connection conn = myFactory.getConnection();
            String sql;
            
            sql = "INSERT INTO customer (name) VALUES (?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, t.getName());
            statement.executeUpdate();
			
	}catch(SQLException e){
            throw new RuntimeException("Failed to save comment");
	}finally{
            close(rs, statement, connection);
	}
    }

    
    public void update(Customer t) {
         try{
            String sql;
            connection = getConnection();
            sql = "Update customer set name = ? where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, t.getName());
            statement.setInt(2, t.getId());
            statement.executeUpdate();
			
	}catch(SQLException e){
            throw new RuntimeException("Failed to save comment");
	}finally{
            close(rs, statement, connection);
	}
    }

    public void delete(Customer t) {
         try{
            String sql;
            connection = getConnection();
            sql = "DELETE customer where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, t.getId());
            statement.executeUpdate();
			
	}catch(SQLException e){
            throw new RuntimeException("Failed to save comment");
	}finally{
            close(rs, statement, connection);
	}
    }

    @Override
    public Object findById(int id) {
        try{
            connection = getConnection();
            String sql = "select * from customer where id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            if (!rs.next()) {
                return null;
            }
            return read(rs);
        }
	catch (SQLException e) {
            throw new RuntimeException(e);
	}
	finally {
            close(rs, statement, connection);
	}
    }

    @Override
    public Set getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private Customer read(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String name = rs.getString("name");

		Customer cust = new Customer(id, name, null);
		
		return cust;
	}

    @Override
    public Object findWhere(String whereStatement) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void create(Object t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Object t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Object t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
