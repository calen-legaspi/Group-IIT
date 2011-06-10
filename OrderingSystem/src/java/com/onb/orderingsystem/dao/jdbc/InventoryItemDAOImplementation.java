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

    public InventoryItemDAOImplementation(Connection connection) {
        super(connection);
    }
    @Override
    public Set<InventoryItem> getAvailableInventoryItems() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateInventoryItem(InventoryItem inventoryItem) throws DAOException, IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
