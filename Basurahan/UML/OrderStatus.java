package com.onb.orderingsystem.domain;

/**
 * @author The Architect
 * @version 1.0
 * @created 07-Jun-2011 9:42:01 AM
 */
/**
 * The OrderStatus enum represents the state of a certain Order:
 * <ol>
 * <li><b>PROCESSING:</b>Temporary/volatile state.</li>
 * <li><b>ON_CREDIT:</b>Finalized to a certain customer.</li>
 * <li><b>CANCELLED:</b>Cancelled.</li>
 * <li><b>PAID:</b>Amount paid out.</li>
 * </ol>
 * <br/>By default, Orders should be on the <b>PROCESSING</b> state.
 * <br/>
 * Possible state changes are:
 * <ol>
 * <li>PROCESSING to ON_CREDIT</li>
 * <li>PROCESSING to CANCELLED</li>
 * <li>ON_CREDIT to PAID</li>
 * </ol>
 */
public enum OrderStatus {

	/**
	 * The Order is still volatile. OrderItems can be changed without limits.
	 */
	PROCESSING,
	
	/**
	 * The Order is on credit terms. Can be changed to PAID when the Customer pays up.<br/>
	 * When upgraded to this state, orderItems can no longer be modified.
	 * During the upgrade, respective InventoryItems should be update to reflect the quantity deductions.
	 */
	ON_CREDIT,
	
	/**
	 * The Order is cancelled, but the order will not be deleted for historical purposes.<br/>
	 * No changes in the quantity of the inventory.
	 */
	CANCELLED,
	
	/**
	 * When the Customer pays up the amount owed to a specific Order.<br/>
	 */
	PAID
}
