package com.onb.shoppingcart.services;

import java.util.List;
import com.onb.shoppingcart.domain.Category;
import com.onb.shoppingcart.domain.Order;
import com.onb.shoppingcart.domain.User;
import com.onb.shoppingcart.services.exceptions.ServiceException;

public interface ShoppingService {
	
	public User getUserByUsername(String username);
	
	public List<Category> getCategories();
	
	public void checkout(Order order) throws ServiceException;
	
}
