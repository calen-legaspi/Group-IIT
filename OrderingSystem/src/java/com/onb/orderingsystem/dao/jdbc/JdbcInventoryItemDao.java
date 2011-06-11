/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.dao.jdbc;

import com.onb.orderingsystem.dao.AbstractDao;
import com.onb.orderingsystem.dao.DaoException;
import com.onb.orderingsystem.dao.InventoryItemDao;
import com.onb.orderingsystem.domain.InventoryItem;
import java.sql.Connection;
import java.util.Set;

/**
 * Implementation of the InventoryItemDao interface.
 * @see com.onb.orderingsystem.dao.InventoryItemDao
 * @see com.onb.orderingsystem.dao.AbstractDao
 */
public class JdbcInventoryItemDao extends AbstractDao implements InventoryItemDao {

    /**
     * 
     * @param connection
     * @throws IllegalArgumentException 
     */
    public JdbcInventoryItemDao(Connection connection) throws IllegalArgumentException {
        super(connection);
    }
    
    /**
     * @see com.onb.orderingsystem.dao.InventoryItemDao
     * @return
     * @throws DaoException 
     */
    @Override
    public Set<InventoryItem> getAvailableInventoryItems() throws DaoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @see com.onb.orderingsystem.dao.InventoryItemDao
     * @param inventoryItem
     * @throws DaoException
     * @throws IllegalArgumentException 
     */
    @Override
    public void updateInventoryItem(InventoryItem inventoryItem) throws DaoException, IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
