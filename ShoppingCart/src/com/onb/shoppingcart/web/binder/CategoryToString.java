package com.onb.shoppingcart.web.binder;

import org.springframework.core.convert.converter.Converter;

import com.onb.shoppingcart.domain.Category;

public class CategoryToString implements Converter<Category, String> {

	@Override
	public String convert(Category category) {
		return category.getId()+"";
	}

}
