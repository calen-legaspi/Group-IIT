/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.dao.jdbc;

import com.onb.orderingsystem.dao.AbstractDao;
import com.onb.orderingsystem.dao.DaoException;
import com.onb.orderingsystem.dao.OrderDao;
import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.domain.DiscountStatus;
import com.onb.orderingsystem.domain.Order;
import com.onb.orderingsystem.domain.OrderItem;
import com.onb.orderingsystem.domain.OrderStatus;
import com.onb.orderingsystem.domain.Product;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementation of the OrderDao interface.
 * @see com.onb.orderingsystem.dao.OrderDao
 * @see com.onb.orderingsystem.dao.AbstractDao
 */
public class JdbcOrderDao extends AbstractDao implements OrderDao {
    
    /**
     * 
     * @param connection
     * @throws IllegalArgumentException 
     */
    JdbcOrderDao(Connection connection) throws IllegalArgumentException {
        super(connection);
    }

    /**
     * @see com.onb.orderingsystem.dao.OrderDao
     * @param order
     * @throws DaoException
     * @throws IllegalArgumentException 
     */
    @Override
    public void createOrder(Order order) throws DaoException, IllegalArgumentException {
        String createOrder = "INSERT INTO orders(customer_id, date, amount, order_status, discount_status) VALUES(?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement insert = connection.prepareStatement(createOrder);
            insert.setInt(1, order.getCustomer().getId());
            insert.setDate(2, new java.sql.Date(order.getDate().getTime()));
            insert.setBigDecimal(3, order.getAmount());
            insert.setString(4, order.getOrderStatus().toString());
            insert.setString(5, order.getDiscountStatus().toString());
            insert.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Query["+createOrder+"] failed:"+e.getMessage());
        }
        
    }

    /**
     * @see com.onb.orderingsystem.dao.OrderDao
     * @param order
     * @throws DaoException
     * @throws IllegalArgumentException 
     */
    @Override
    public void updateOrder(Order order) throws DaoException, IllegalArgumentException {
        String updateOrder = "UPDATE orders SET date = ?, amount = ?, order_status = ?, discount_status = ? WHERE order_number = ?";
        
        try {
            PreparedStatement update = connection.prepareStatement(updateOrder);
            update.setDate(1, new java.sql.Date(order.getDate().getTime()));
            update.setBigDecimal(2, order.getAmount());
            update.setString(3, order.getOrderStatus().toString());
            update.setString(4, order.getDiscountStatus().toString());
            update.setInt(5, order.getOrderNumber());
            update.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Query["+updateOrder+"] failed:"+e.getMessage());
        }
        
    }

    /**
     * @see com.onb.orderingsystem.dao.OrderDao
     * @param customer
     * @return
     * @throws DaoException
     * @throws IllegalArgumentException 
     */
    @Override
    public List<Order> getOrderByCustomerSortedByDateDescending(Customer customer) throws DaoException, IllegalArgumentException {
        List<Order> ordersSortedByDate = new LinkedList<Order>();
        String selectOrdersByCustomer = "SELECT * FROM orders WHERE customer_id = ? ORDER BY date DESC";
        try {
            PreparedStatement select = connection.prepareStatement(selectOrdersByCustomer);
            select.setInt(1,customer.getId());
            ResultSet result = select.executeQuery();
            while(result.next()) {
                Set<OrderItem> orderItems = new LinkedHashSet<OrderItem>();
                Order o = new Order(result.getInt("order_number"), result.getDate("date"), orderItems, OrderStatus.fromString(result.getString("order_status")), DiscountStatus.fromString("discount_status"), result.getBigDecimal("amount"));
                restoreOrderItemsForOrder(o, orderItems);
                ordersSortedByDate.add(o);
            }
        } catch (SQLException e) {
            throw new DaoException("Query["+selectOrdersByCustomer+"] failed:"+e.getMessage());
        }
        return ordersSortedByDate;
    }
    
    //restores the order items for the specified order
    private void restoreOrderItemsForOrder(Order o,Set<OrderItem> orderItems) throws DaoException {
        String orderItemQueryForOrder = "SELECT * FROM order_items AS oi,products AS p WHERE oi.product_sku_number = p.sku_number AND oi.order_order_number = ?";
        
        try {
            PreparedStatement select = connection.prepareStatement(orderItemQueryForOrder);
            select.setInt(1, o.getOrderNumber());
            ResultSet result = select.executeQuery();
            while(result.next()) {
                OrderItem oi = new OrderItem(result.getInt("oi.id"), new Product(result.getInt("p.sku_number"),result.getString("p.name"), result.getBigDecimal("p.amount")), result.getInt("oi.quantity"));
                orderItems.add(oi);
            }
        } catch (SQLException e) {
            throw new DaoException("Query ["+orderItemQueryForOrder+"] failed:"+e.getMessage());
        }
    }
    
}
