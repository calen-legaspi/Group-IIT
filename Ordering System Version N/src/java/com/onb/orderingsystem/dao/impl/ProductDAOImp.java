/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.dao.impl;

import com.onb.orderingsystem.dao.*;
import com.onb.orderingsystem.domain.Product;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


public class ProductDAOImp{
    
    DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
     
    public void create(Product t) {
       try{
            Connection conn = myFactory.getConnection();
            String sql = "INSERT INTO product (name, amount) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, t.getName());
            statement.setDouble(2, t.getAmount().doubleValue());
            statement.executeUpdate();
            conn.close();
	}catch(SQLException e){
            throw new RuntimeException("Failed to save product");
	}
    }

    
    public void update(Product t) {
         try{
            String sql;
            connection = getConnection();
            sql = "Update product set name = ?, price = ? where sku_number = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, t.getName());
            statement.setDouble(2, t.getAmount().doubleValue());
            statement.setInt(3, t.getSkuNumber());
            statement.executeUpdate();
			
	}catch(SQLException e){
            throw new RuntimeException("Failed to save comment");
	}finally{
            close(rs, statement, connection);
	}
    }

    public void delete(Product t) {
         try{
            String sql;
            connection = getConnection();
            sql = "DELETE from product where sku_number = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, t.getSkuNumber());
            statement.executeUpdate();
			
	}catch(SQLException e){
            throw new RuntimeException("Failed to save comment");
	}finally{
            close(rs, statement, connection);
	}
    }
    
    public Set<Product> findWhere(String sql){
        Set<Product> products = new HashSet<Product>();
         try{
            connection = getConnection();
            String sql2 = "select * from product where ? order by sku_number";
            statement = connection.prepareStatement(sql2);
            statement.setString(1, sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                products.add(read(rs));
            }
            return products;
        }
	catch (SQLException e) {
            throw new RuntimeException(e);
	}
	finally {
            close(rs, statement, connection);
	}
    }

    @Override
    public Product findById(int id) {
        try{
            connection = getConnection();
            String sql = "select * from product where id=?";
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
    public Set<Product> getAll() {
        Set<Product> products = new HashSet<Product>();
         try{
            connection = getConnection();
            String sql = "select * from product order by sku_number";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                products.add(read(rs));
            }
            return products;
        }
	catch (SQLException e) {
            throw new RuntimeException(e);
	}
	finally {
            close(rs, statement, connection);
	}
    }

    private Product read(ResultSet rs) throws SQLException {

                int number = rs.getInt("sku_number");
		String name = rs.getString("name");
                BigDecimal price = new BigDecimal(rs.getDouble("amount")+"");

		Product prod = new Product(number, name, price);
		
		return prod;
	}
}
