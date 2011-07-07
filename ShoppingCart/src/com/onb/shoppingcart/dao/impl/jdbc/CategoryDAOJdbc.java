package com.onb.shoppingcart.dao.impl.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.onb.shoppingcart.dao.CategoryDAO;
import com.onb.shoppingcart.domain.Category;
import com.onb.shoppingcart.domain.Product;

@Repository("categoryDAO")
public class CategoryDAOJdbc extends AbstractDAOJdbc implements CategoryDAO {
	private static final String INSERT = "INSERT INTO categories(name) VALUES(?)";
	private static final String SELECT_ALL_CATEGORIES = "SELECT id, name FROM categories";
	private static final String SELECT_BY_ID = "SELECT id, name FROM categories WHERE id=?";
	
	@Override
	public void create(Category category) {
		Object[] params = {category.getName()};
		synchronized (insertionLock) {
			getJdbcTemplate().update(INSERT, params);
			category.setId(getLastInsertId());
		}
	}
	
	@Override
	public List<Category> getAll() {
		return getJdbcTemplate().query(SELECT_ALL_CATEGORIES, new RowMapper<Category>(){
			private static final String GET_PRODUCTS_FOR_CATEGORY = "SELECT id, name, quantity, unit_price FROM products WHERE category_id=?";
			
			@Override
			public Category mapRow(ResultSet rs, int row) throws SQLException {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				Object[] params = {category.getId()};
				category.setProducts(getJdbcTemplate().query(GET_PRODUCTS_FOR_CATEGORY, params, new RowMapper<Product>() {

					@Override
					public Product mapRow(ResultSet rsProd, int rowProd) throws SQLException {
						Product product = new Product();
						product.setId(rsProd.getInt("id"));
						product.setName(rsProd.getString("name"));
						product.setQuantity(rsProd.getInt("quantity"));
						product.setUnitPrice(rsProd.getBigDecimal("unit_price"));
						return product;
					}
				}));
				return category;
			}
		});
	}

	@Override
	public Category get(int id) {
		Object[] params = {id};
		return getJdbcTemplate().queryForObject(SELECT_BY_ID, params, new RowMapper<Category>() {
			private static final String SELECT_PRODUCTS_BY_CATEGORY = "SELECT id, category_id, name, quantity, unit_price FROM products WHERE category_id=?";
			
			@Override
			public Category mapRow(ResultSet rs, int row) throws SQLException {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				
				Object[] paramsProd = {category.getId()};
				category.setProducts(getJdbcTemplate().query(SELECT_PRODUCTS_BY_CATEGORY, paramsProd, new RowMapper<Product>() {

					@Override
					public Product mapRow(ResultSet rsProd, int rowProd) throws SQLException {
						Product product = new Product();
						product.setId(rsProd.getInt("id"));
						product.setName(rsProd.getString("name"));
						product.setQuantity(rsProd.getInt("quantity"));
						product.setUnitPrice(rsProd.getBigDecimal("unit_price"));
						return product;
					}
				}));
				return category;
			}
		});
	}



	@Override
	protected String getTableName() {
		return "categories";
	}

}
