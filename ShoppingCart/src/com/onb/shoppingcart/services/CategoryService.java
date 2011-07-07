package com.onb.shoppingcart.services;

import java.util.List;

import com.onb.shoppingcart.domain.Category;
import com.onb.shoppingcart.services.exceptions.ServiceException;

public interface CategoryService {

	public void create(Category category) throws ServiceException;
	
	public List<Category> getAll();
}
