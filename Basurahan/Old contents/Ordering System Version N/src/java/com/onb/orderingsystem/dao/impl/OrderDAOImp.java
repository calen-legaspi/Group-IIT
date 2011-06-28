/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.dao.impl;

import com.onb.orderingsystem.dao.DBConnectionFactory;
import com.onb.orderingsystem.dao.OrderDAO;
import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.domain.DiscountStatus;
import com.onb.orderingsystem.domain.Order;
import com.onb.orderingsystem.domain.OrderStatus;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class OrderDAOImp implements OrderDAO{

    DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
    
    /**
     * 
     * @param customer
     * @return Set<Order> 
     */
    
    @Override
    public Set<Order> getCustomerOrders(Customer customer) {
         if(customer == null){ throw new NullPointerException("Customer cannot be null"); }
        try{
            Set<Order> customerOrders = new HashSet<Order>();
            Connection conn = myFactory.getConnection();
            String sql = "SELECT * FROM orders where customer_id = ? order by date";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, customer.getId());
            ResultSet rs = statement.executeQuery();
           while(rs.next()) { 
                customerOrders.add(toOrder(rs, customer));
            }
           
            return customerOrders;
        }catch(SQLException e){
            throw new RuntimeException("Failed to get unpaid orders: ", e);
        }
    }
    
    @Override
    public void payCustomerOrder(int order_id){
         try{
            Connection conn = myFactory.getConnection();
            String sql = "UPDATE orders SET order_status = 'PAID' where order_number = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, order_id);
            statement.executeUpdate();
            conn.close();
        }catch(SQLException e){
            throw new RuntimeException("Failed to process order for payment: ", e);
        }
    }
    
    @Override
    public int getCustomerIdAssocWithOrder(int order_number){
         try{
            Connection conn = myFactory.getConnection();
            String sql = "SELECT customer_id FROM orders where order_number = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, order_number);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                int customer_id = rs.getInt("customer_id");
                return customer_id;
            }
           return 0;
            
        }catch(SQLException e){
            throw new RuntimeException("Failed to get customer id: "+e);
        }
    }
    
    @Override
    public Set<Order> getCustomerUnpaidOrders(Customer customer){
        if(customer == null){ throw new NullPointerException("Customer cannot be null"); }
        try{
            Set<Order> customerOrders = new HashSet<Order>();
            Connection conn = myFactory.getConnection();
            String sql = "SELECT * FROM orders where customer_id = ? AND order_status='UNPAID' order by date";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, customer.getId());
            ResultSet result = statement.executeQuery();
           while(result.next()) { 
                customerOrders.add(toOrder(result, customer));
            }
            return customerOrders;
        }catch(SQLException e){
            throw new RuntimeException("Failed to get unpaid orders: "+ e);
        }
    }
    
    private Order toOrder(ResultSet rs, Customer customer) throws SQLException {
		int order_number = rs.getInt("order_number");
		BigDecimal amount = rs.getBigDecimal("amount_with_discount");
                Date date = rs.getDate("date");
                OrderStatus order_status = OrderStatus.valueOf(rs.getString("order_status"));
                DiscountStatus discount_status = DiscountStatus.valueOf(rs.getString("discount_status"));
		Order order = new Order(order_number, date, null, order_status, discount_status, amount);
                order.setCustomer(customer);
		return order;
    } 
    
}
