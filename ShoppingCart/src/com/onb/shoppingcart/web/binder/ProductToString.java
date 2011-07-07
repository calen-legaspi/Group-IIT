package com.onb.shoppingcart.web.binder;

import org.springframework.core.convert.converter.Converter;

import com.onb.shoppingcart.domain.Product;

public class ProductToString implements Converter<Product, String> {

	@Override
	public String convert(Product p) {
		return p.getId()+"";
	}

}
