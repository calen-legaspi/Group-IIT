package com.onb.orderingsystem.dao.impl;

import com.onb.orderingsystem.dao.CustomerDAO;
import com.onb.orderingsystem.dao.DBConnectionFactory;
import com.onb.orderingsystem.domain.Customer;
import com.onb.orderingsystem.domain.DiscountStatus;
import com.onb.orderingsystem.domain.Order;
import com.onb.orderingsystem.domain.OrderItem;
import com.onb.orderingsystem.domain.OrderStatus;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class CustomerDAOimp implements CustomerDAO{

    DBConnectionFactory myFactory = DBConnectionFactory.getInstance();

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
    public Set<Customer> getAllUnpaid() {
        try{
            Set<Customer> unpaidCustomers = new HashSet<Customer>();
            Set<Order> order = new HashSet<Order>();
            Set<OrderItem> items = new HashSet<OrderItem>();
            
            Connection conn = myFactory.getConnection();
            String sql = "select * from customer c, order o, order_item oi, product p where o.order_status = 'UNPAID' and c.id = o.customer_id order by c.id";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            Customer curr = readCust(rs);
            while (rs.next()) {
                
                if(curr.getId() == rs.getInt("id"))
                 curr = readCust(rs);
                if(!unpaidCustomers.contains(cust)){
                    unpaidCustomers.
             
                unpaidCustomers.add(read(rs));
            }
        }
	catch (SQLException e) {
            throw new RuntimeException("Error on find by ID");
	}
    }

    private Customer readCust(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		Customer cust = new Customer(id, name, null);
		return cust;
    }
    
    private Order readOrder(ResultSet rs) throws SQLException{
            int id = rs.getInt("order_number");
            BigDecimal amount = rs.getBigDecimal("amount_with_discount");
            Date date = rs.getDate("date");
            OrderStatus ordStat = OrderStatus.valueOf(rs.getString("order_status"));
            DiscountStatus discStat = DiscountStatus.valueOf(rs.getString("discount_status"));
            Order o = new Order(id, date, null, ordStat, discStat, amount);
            return o;
    }
    
}
