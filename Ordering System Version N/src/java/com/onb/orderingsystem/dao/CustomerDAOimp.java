/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.dao;

import com.onb.orderingsystem.domain.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

/**
 *
 * @author juliusmercons
 */
public class CustomerDAOimp extends DAOImpl implements CustomerDAO{

    public void create(Customer t) {
       try{
            String sql;
            connection = getConnection();
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
    
}
