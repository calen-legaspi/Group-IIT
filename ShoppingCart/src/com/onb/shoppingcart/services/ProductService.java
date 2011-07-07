package com.onb.shoppingcart.services;

import com.onb.shoppingcart.domain.Product;
import com.onb.shoppingcart.services.exceptions.ServiceException;

public interface ProductService {

	public void create(Product product) throws ServiceException;
	
}
