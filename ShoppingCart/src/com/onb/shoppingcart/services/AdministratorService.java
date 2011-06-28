package com.onb.shoppingcart.services;

import com.onb.shoppingcart.domain.Category;
import com.onb.shoppingcart.domain.Product;

public interface AdministratorService {

	public void addCategory(Category category);
	
	public void addProduct(Product product);
}
