package com.onb.orderingsystem.dao;

public interface DAOFactory {
    public CustomerDao getCustomerDao();
    public InventoryItemDao getInventoryItemDao();
    public OrderDao getOrderDao();
    public OrderItemDao getOrderItemDao();
}
