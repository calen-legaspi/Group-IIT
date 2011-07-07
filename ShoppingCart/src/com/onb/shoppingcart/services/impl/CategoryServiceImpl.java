package com.onb.shoppingcart.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onb.shoppingcart.dao.CategoryDAO;
import com.onb.shoppingcart.domain.Category;
import com.onb.shoppingcart.services.CategoryService;
import com.onb.shoppingcart.services.exceptions.ServiceException;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
	private CategoryDAO categoryDAO;

	@Autowired(required = true)
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	@Override
	public void create(Category category) throws ServiceException {
		categoryDAO.create(category);
	}

	@Override
	public List<Category> getAll() {
		return categoryDAO.getAll();
	}

}
