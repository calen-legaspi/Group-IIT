package com.onb.orderingsystem.dao.jdbc;

import com.onb.orderingsystem.dao.AbstractDao;
import com.onb.orderingsystem.dao.CustomerDao;
import com.onb.orderingsystem.dao.DaoException;
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
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementation of the CustomerDao interface.
 * @see com.onb.orderingsystem.dao.CustomerDao
 * @see com.onb.orderingsystem.dao.AbstractDao
 */
public class JdbcCustomerDao extends AbstractDao implements CustomerDao {
    
    /**
     * @see java.sql.Connection
     * @param connection 
     * @throws IllegalArgumentException if the connection is null.
     */
    public JdbcCustomerDao(Connection connection) throws IllegalArgumentException {
        super(connection);
    }

    /**
     * @see com.onb.orderingsystem.dao.CustomerDao
     * @return
     * @throws DaoException 
     */
    @Override
    public Set<Customer> getCustomersCreditLimitNotExceeded() throws DaoException {
        Set<Customer> customersCreditLimitNotExceeded = new LinkedHashSet<Customer>();
        Set<Customer> allCustomers = getAllCustomers();
        
        for(Customer c: allCustomers) {
            if(c.isCreditLimitNotExceeded()) {
                customersCreditLimitNotExceeded.add(c);
            }
        }
        
        return customersCreditLimitNotExceeded;
    }

    /**
     * @see com.onb.orderingsystem.dao.CustomerDao
     * @return
     * @throws DaoException 
     */
    @Override
    public Set<Customer> getCustomersWithUnpaidOrders() throws DaoException {
        Set<Customer> customersWithUnpaidOrders = new LinkedHashSet<Customer>();
        Set<Customer> allCustomers = getAllCustomers();
        
        for(Customer c:allCustomers) {
            if(c.hasUnpaidOrders()) {
                customersWithUnpaidOrders.add(c);
            }
        }
        
        return customersWithUnpaidOrders;
    }

    /**
     * @see com.onb.orderingsystem.dao.CustomerDao
     * @return
     * @throws DaoException 
     */
    @Override
    public Set<Customer> getAllCustomers() throws DaoException {
        Set<Customer> allCustomers = new LinkedHashSet<Customer>();
        String customerQueryAll = "SELECT * FROM customers";
        
        try {
            Statement select = connection.createStatement();
            ResultSet result = select.executeQuery(customerQueryAll);
            while(result.next()) {
                Customer c = new Customer(result.getInt("id"), result.getString("name"), new LinkedHashSet<Order>());
                restoreOrdersForCustomer(c);
                allCustomers.add(c);
            }
        } catch (SQLException e) {
            throw new DaoException("Query["+customerQueryAll+"] failed:"+e.getMessage());
        }
        
        return allCustomers;
    }
    
    //restores the order objects for the specified customer
    private void restoreOrdersForCustomer(Customer c) throws DaoException {
        String orderQueryAllForCustomer = "SELECT * FROM orders WHERE customer_id = ?";
        
        try {
            PreparedStatement select = connection.prepareStatement(orderQueryAllForCustomer);
            select.setInt(1, c.getId());
            ResultSet result = select.executeQuery();
            while(result.next()) {
                Order o = new Order(result.getInt("order_number"), result.getDate("date"), new LinkedHashSet<OrderItem>(), OrderStatus.fromString(result.getString("order_status")), DiscountStatus.fromString(result.getString("discount_status")), result.getBigDecimal("amount"));
                restoreOrderItemsForOrder(o);
                c.addOrder(o);
            }
        } catch (SQLException e) {
            throw new DaoException("Query ["+orderQueryAllForCustomer+"] failed:"+e.getMessage());
        }
    }
    
    //restores the order items for the specified order
    private void restoreOrderItemsForOrder(Order o) throws DaoException {
        String orderItemQueryForOrder = "SELECT * FROM order_items AS oi,products AS p WHERE oi.product_sku_number = p.sku_number AND oi.order_order_number = ?";
        
        try {
            PreparedStatement select = connection.prepareStatement(orderItemQueryForOrder);
            select.setInt(1, o.getOrderNumber());
            ResultSet result = select.executeQuery();
            while(result.next()) {
                OrderItem oi = new OrderItem(result.getInt("oi.id"), new Product(result.getInt("p.sku_number"),result.getString("p.name"), result.getBigDecimal("p.amount")), result.getInt("oi.quantity"));
                o.addOrderItem(oi);
            }
        } catch (SQLException e) {
            throw new DaoException("Query ["+orderItemQueryForOrder+"] failed:"+e.getMessage());
        }
    }
    
}
