package com.onb.orderingsystem.dao.jdbc;

import com.onb.orderingsystem.dao.CustomerDao;
import com.onb.orderingsystem.dao.DAOFactory;
import com.onb.orderingsystem.dao.InventoryItemDao;
import com.onb.orderingsystem.dao.OrderDao;
import com.onb.orderingsystem.dao.OrderItemDao;

public class JdbcDAOFactory implements DAOFactory {

    @Override
    public CustomerDao getCustomerDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public InventoryItemDao getInventoryItemDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OrderDao getOrderDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OrderItemDao getOrderItemDao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
