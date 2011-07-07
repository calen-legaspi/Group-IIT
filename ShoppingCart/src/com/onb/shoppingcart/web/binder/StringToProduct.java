package com.onb.shoppingcart.web.binder;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.core.convert.converter.Converter;
import org.springframework.jdbc.core.RowMapper;

import com.onb.shoppingcart.domain.Category;
import com.onb.shoppingcart.domain.Product;

public class StringToProduct extends JdbcExtractorConverter implements Converter<String, Product> {
	private static final String SELECT = "SELECT p.id,p.name,p.quantity,p.unit_price,c.id,c.name FROM products WHERE p.category_id=c.id FROM products AS p, categories AS c WHERE id=?";

	@Override
	public Product convert(String id) {
		Object[] params = {Integer.parseInt(id)};
		return jdbcTemplate.queryForObject(SELECT, params, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int row) throws SQLException {
				Category category = new Category();
				category.setId(rs.getInt("c.id"));
				category.setName(rs.getString("c.name"));
				Product product = new Product();
				product.setCategory(category);
				product.setId(rs.getInt("p.id"));
				product.setName(rs.getString("p.name"));
				product.setQuantity(rs.getInt("p.quantity"));
				product.setUnitPrice(rs.getBigDecimal("p.unit_price"));
				return product;
			}
			
		});
	}

}
