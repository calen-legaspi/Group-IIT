package com.onb.shoppingcart.dao.impl.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.onb.shoppingcart.dao.ProductDAO;
import com.onb.shoppingcart.domain.Category;
import com.onb.shoppingcart.domain.Product;

@Repository("productDAO")
public class ProductDAOJdbc extends AbstractDAOJdbc implements ProductDAO {
	private static final String INSERT = "INSERT INTO products(name, category_id, quantity, unit_price) VALUES(?,?,?,?)";
	private static final String UPDATE_QTY = "UPDATE products SET quantity=quantity-? WHERE id=?";
	private static final String FIND_BY_ID = "SELECT id, category_id, name, quantity, unit_price FROM products";

	@Override
	public void create(Product product) {
		Object[] params = {product.getName(), product.getCategory().getId(), product.getQuantity(), product.getUnitPrice()};
		synchronized (insertionLock) {
			getJdbcTemplate().update(INSERT, params);
			product.setId(getLastInsertId());
		}
	}

	@Override
	public void reduceQuantity(Product product, int reduceByThisMuch) {
		Object[] params = {reduceByThisMuch, product.getId()};
		getJdbcTemplate().update(UPDATE_QTY, params);
	}

	@Override
	public Product get(int id) {
		Object[] params = {id};
		return getJdbcTemplate().queryForObject(FIND_BY_ID, params, new RowMapper<Product>() {
			private static final String FIND_CATEGORY = "SELECT name FROM categories WHERE id=?";

			@Override
			public Product mapRow(ResultSet rs, int row) throws SQLException {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setQuantity(rs.getInt("quantity"));
				
				Object[] paramsProd = {rs.getInt("category_id")};
				product.setCategory(getJdbcTemplate().queryForObject(FIND_CATEGORY, paramsProd, new RowMapper<Category>() {

					@Override
					public Category mapRow(ResultSet rsCat, int rowCat) throws SQLException {
						Category category = new Category();
						category.setId(rsCat.getInt("id"));
						category.setName(rsCat.getString("name"));
						return category;
					}}));
				
				return product;
			}
		});
	}

	@Override
	protected String getTableName() {
		return "products";
	}

}
