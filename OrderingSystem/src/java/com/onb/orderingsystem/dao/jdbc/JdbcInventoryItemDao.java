/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onb.orderingsystem.dao.jdbc;

import java.sql.PreparedStatement;
import com.onb.orderingsystem.dao.AbstractDao;
import com.onb.orderingsystem.dao.DaoException;
import com.onb.orderingsystem.dao.InventoryItemDao;
import com.onb.orderingsystem.domain.InventoryItem;
import com.onb.orderingsystem.domain.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Implementation of the InventoryItemDao interface.
 * @see com.onb.orderingsystem.dao.InventoryItemDao
 * @see com.onb.orderingsystem.dao.AbstractDao
 */
public class JdbcInventoryItemDao extends AbstractDao implements InventoryItemDao {

    /**
     * Do not access this directly. Use JdbcDAOFactory for that purpose.
     * @see JdbcDAOFactory use this to acquire an instance.
     * @param connection
     * @throws IllegalArgumentException 
     */
    JdbcInventoryItemDao(Connection connection) throws IllegalArgumentException {
        super(connection);
    }
    
    /**
     * @see com.onb.orderingsystem.dao.InventoryItemDao
     * @return
     * @throws DaoException 
     */
    @Override
    public Set<InventoryItem> getAvailableInventoryItems() throws DaoException {
        Set<InventoryItem> availableInventoryItems = new LinkedHashSet<InventoryItem>();
        String queryAvailableInventoryItems = "SELECT * FROM inventory_items AS ii,products AS p WHERE ii.quantity > 0 AND ii.product_sku_number = p.sku_number";
        
        try {
            PreparedStatement select = connection.prepareStatement(queryAvailableInventoryItems);
            ResultSet result = select.executeQuery();
            while(result.next()) {
                InventoryItem ii = new InventoryItem(result.getInt("ii.id"), new Product(result.getInt("p.sku_number"), result.getString("p.name"), result.getBigDecimal("p.amount")), result.getInt("ii.quantity"));
                availableInventoryItems.add(ii);
            }
        } catch (SQLException e) {
            throw new DaoException("Query ["+queryAvailableInventoryItems+"] failed:"+e.getMessage());
        }
        
        return availableInventoryItems;
    }

    /**
     * @see com.onb.orderingsystem.dao.InventoryItemDao
     * @param inventoryItem
     * @throws DaoException
     * @throws IllegalArgumentException 
     */
    @Override
    public void updateInventoryItem(InventoryItem inventoryItem) throws DaoException, IllegalArgumentException {
        String updateInventoryItem = "UPDATE inventory_items SET product_sku_number = ?, inventory_id = ? ,quantity = ? WHERE id = ?";
        
        
    }
    
}
