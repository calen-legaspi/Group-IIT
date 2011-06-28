package com.onb.shoppingcart.services;

import java.util.Set;

import com.onb.shoppingcart.domain.Category;
import com.onb.shoppingcart.domain.Order;

public interface ShoppingService {

	public Set<Category> getCategories();
	
	public void checkoutOrder(Order order);
}
