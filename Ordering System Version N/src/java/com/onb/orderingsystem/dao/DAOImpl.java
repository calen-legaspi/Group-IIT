/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.dao;

import java.sql.*;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author 
 */
public class DAOImpl implements DAO{

    private static final String dbClassName = "com.mysql.jdbc.Driver";
    private static final String CONNECTION = "jdbc:mysql://127.0.0.1/OrderingSystem";
    private static Object idLock = new Object();
    private static Connection c;
    private static Properties p;
    protected static ResultSet rs;
    protected static PreparedStatement statement;
    protected static Connection connection;
    
    protected static Connection getConnection(){
		try {
			loadJDBC();
			p = new Properties();
			p.put("user","root");
			p.put("password","qwerty");
			c = DriverManager.getConnection(CONNECTION,p);
			return c;
		} catch (SQLException e) {
			throw new RuntimeException("Database connection failed");
		}
	}
    
    private static void loadJDBC(){
		try{
			Class.forName(dbClassName);
		}catch(ClassNotFoundException e){
			throw new RuntimeException("JDBC driver cannot be found");
		}
	}
    
    protected static void close(Statement statement, Connection connection){
		
		close(null, statement, connection);
    }
    
    protected static void close(ResultSet rs, Statement statement,
			Connection connection) 
	{
		try {
			if (rs != null)
				rs.close();
			if (statement != null)
				statement.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
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

    @Override
    public Object findById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object findWhere(String whereStatement) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
