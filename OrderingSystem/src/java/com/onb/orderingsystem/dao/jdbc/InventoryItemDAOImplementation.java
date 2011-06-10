/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.dao.jdbc;

import com.onb.orderingsystem.dao.AbstractDAO;
import com.onb.orderingsystem.dao.DAOException;
import com.onb.orderingsystem.dao.InventoryItemDAO;
import com.onb.orderingsystem.domain.InventoryItem;
import java.sql.Connection;
import java.util.Set;

/**
 *
 * @author lyndon
 */
public class InventoryItemDAOImplementation extends AbstractDAO implements InventoryItemDAO {

    /**
     * 
     * @param connection
     * @throws IllegalArgumentException 
     */
    public InventoryItemDAOImplementation(Connection connection) throws IllegalArgumentException {
        super(connection);
    }
    
    /**
     * @see com.onb.orderingsystem.dao.InventoryItemDAO
     * @return
     * @throws DAOException 
     */
    @Override
    public Set<InventoryItem> getAvailableInventoryItems() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @see com.onb.orderingsystem.dao.InventoryItemDAO
     * @param inventoryItem
     * @throws DAOException
     * @throws IllegalArgumentException 
     */
    @Override
    public void updateInventoryItem(InventoryItem inventoryItem) throws DAOException, IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
