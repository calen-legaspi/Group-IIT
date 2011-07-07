package com.onb.shoppingcart.dao;

import com.onb.shoppingcart.domain.Product;

public interface ProductDAO {
	
	public Product get(int id);

	public void create(Product product);
	
	public void reduceQuantity(Product product, int reduceByThisMuch);
	
}
