package com.onb.shoppingcart.web.binder;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.core.convert.converter.Converter;
import org.springframework.jdbc.core.RowMapper;

import com.onb.shoppingcart.domain.Category;
import com.onb.shoppingcart.domain.Product;

public class StringToCategory extends JdbcExtractorConverter implements Converter<String, Category> {
	private static final String SELECT = "SELECT id, name FROM categories WHERE id = ?";
	
	@Override
	public Category convert(String id) {
		Object[] params = {Integer.parseInt(id)};
		return jdbcTemplate.queryForObject(SELECT, params, new RowMapper<Category>(){
			public static final String SELECT_PRODUCTS = "SELECT id, name, quantity, unit_price FROM products WHERE category_id = ?";

			@Override
			public Category mapRow(ResultSet rs, int row) throws SQLException {
				final Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				
				Object[] params_products = {category.getId()};
				category.setProducts(jdbcTemplate.query(SELECT_PRODUCTS, params_products, new RowMapper<Product>() {

					@Override
					public Product mapRow(ResultSet rs_products, int row_products) throws SQLException {
						Product p = new Product();
						p.setCategory(category);
						p.setId(rs_products.getInt("id"));
						p.setName(rs_products.getString("name"));
						p.setQuantity(rs_products.getInt("quantity"));
						p.setUnitPrice(rs_products.getBigDecimal("unit_price"));
						return p;
					}
				}));
				return category;
			}
		});
	}

}
