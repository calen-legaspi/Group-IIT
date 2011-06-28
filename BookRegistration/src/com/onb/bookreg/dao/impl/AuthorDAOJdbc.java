package com.onb.bookreg.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.onb.bookreg.dao.AuthorDAO;
import com.onb.bookreg.domain.Author;

@Repository("authorDAO")
public class AuthorDAOJdbc extends AbstractJdbcDAO implements AuthorDAO {
	private static final String INSERT = "INSERT INTO author(name) VALUES(?)";
	private static final String SELECT_ALL = "SELECT id,name FROM author";
	private static final String SELECT_BY_ID = "SELECT id, name FROM author WHERE id=?";
	private static final String UPDATE = "UPDATE author SET name=? WHERE id=?";
	private static final String DELETE = "DELETE FROM author WHERE id=?";

	@Override
	public Author get(Long id) {
		Object[] param = {id};
		
		return getJdbcTemplate().queryForObject(SELECT_BY_ID, param, new RowMapper<Author>()  {

			@Override
			public Author mapRow(ResultSet rs, int row) throws SQLException {
				Author author = new Author();
				author.setId(rs.getInt("id"));
				author.setName(rs.getString("name"));
				return author;
			}
		});
	}

	@Override
	public List<Author> getAll() {
		return getJdbcTemplate().query(SELECT_ALL, new RowMapper<Author>() {
			@Override
			public Author mapRow(ResultSet rs, int row) throws SQLException {
				Author author = new Author();
				author.setId(rs.getInt("id"));
				author.setName(rs.getString("name"));
				return author;
			}
		});
	}

	@Override
	public void create(Author author) {
		getJdbcTemplate().update(INSERT, author.getName());
	}

	@Override
	public void update(Author author) {
		Object[] params = {author.getName(), author.getId()};
		getJdbcTemplate().update(UPDATE, params);
	}

	@Override
	public void delete(Long id) {
		Object[] params = {id};
		getJdbcTemplate().update(DELETE, params);
	}

}
