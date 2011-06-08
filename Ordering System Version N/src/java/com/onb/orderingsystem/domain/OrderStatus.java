package com.onb.orderingsystem.domain;

/**
 * The OrderStatus enum represents the state of a certain Order:
 * <ol>
 * <li><b>ON_CREDIT:</b>Finalized to a certain customer.</li>
 * <li><b>PAID:</b>Amount paid out.</li>
 * </ol>
 * <br/>By default, Orders should be on the <b>ON_CREDIT</b> state.
 */
public enum OrderStatus {

   
    /**
     * The Order is on credit terms. Can be changed to PAID when the Customer pays up.<br/>
     * When upgraded to this state, orderItems can no longer be modified.
     * During the upgrade, respective InventoryItems should be updated to reflect the quantity deductions.
     */
    ON_CREDIT,
    
    /**
     * When the Customer pays up the amount owed to a specific Order.<br/>
     */
    PAID
}
