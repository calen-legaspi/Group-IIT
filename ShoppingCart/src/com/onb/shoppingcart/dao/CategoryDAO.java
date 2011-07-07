package com.onb.shoppingcart.dao;

import java.util.List;
import com.onb.shoppingcart.domain.Category;

public interface CategoryDAO {

	public void create(Category category);
	
	public List<Category> getAll();
	
	public Category get(int id);
}
