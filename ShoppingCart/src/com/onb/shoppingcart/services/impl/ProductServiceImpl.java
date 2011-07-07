package com.onb.shoppingcart.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onb.shoppingcart.dao.ProductDAO;
import com.onb.shoppingcart.domain.Product;
import com.onb.shoppingcart.services.ProductService;
import com.onb.shoppingcart.services.exceptions.ServiceException;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	private ProductDAO productDAO;

	@Autowired(required = true)
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
	public void create(Product product) throws ServiceException {
		productDAO.create(product);
	}

}
