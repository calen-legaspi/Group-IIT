package com.onb.orderingsystem.domain;

/**
 * The OrderStatus enum represents the state of a certain Order:
 * <ol>
 * <li><b>PROCESSING:</b>Default.</li>
 * <li><b>UNPAID:</b>Order was not yet paid.</li>
 * <li><b>PAID:</b>Amount paid out.</li>
 * </ol>
 * <br/>
 * By default, Orders should be on the <b>PROCESSING</b> state.
 */
public enum OrderStatus {

	/**
	 * When an order gets cancelled.
	 */
	CANCELLED,

	/**
	 * The default order status. This is when you can add, remove, etc anything
	 * in the order. This is when you can still update the total amount. This is
	 * when you can still screw up without ruining the database. This is when
	 * you ....can do anything.
	 */
	PROCESSING,

	/**
	 * The Order is on credit terms. Can be changed to PAID when the Customer
	 * pays up.<br/>
	 * When upgraded to this state, orderItems can no longer be modified. During
	 * the upgrade, respective InventoryItems should be updated to reflect the
	 * quantity deductions.
	 */
	UNPAID,

	/**
	 * When the Customer pays up the amount owed to a specific Order.<br/>
	 */
	PAID;

	/**
	 * 
	 * @param stringForm
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static OrderStatus fromString(String stringForm)
			throws IllegalArgumentException {
		for (OrderStatus o : OrderStatus.values()) {
			if (o.toString().equals(stringForm)) {
				return o;
			}
		}
		throw new IllegalArgumentException("OrderStatus \"" + stringForm
				+ "\" does not exist.");
	}
}
