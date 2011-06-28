package com.onb.bookreg.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.onb.bookreg.dao.BookDAO;
import com.onb.bookreg.domain.Author;
import com.onb.bookreg.domain.Book;

@Repository("bookDAO")
public class BookDAOJdbc extends AbstractJdbcDAO implements BookDAO {
	private static final String INSERT = "INSERT INTO book(title,author_id) VALUES(?,?)";
	private static final String SELECT_ALL = "SELECT book.id, book.title, book.author_id, author.name FROM book, author WHERE book.author_id=author.id";
	private static final String SELECT_BY_ID = "SELECT id, title, author_id FROM book WHERE id=?";
	private static final String UPDATE = "UPDATE book SET title=?,author_id=? WHERE id=?";
	private static final String DELETE = "DELETE FROM book WHERE id=?";
	
	@Override
	public Book get(Long id) {
		Object[] params = {id};
		return getJdbcTemplate().queryForObject(SELECT_BY_ID, params, new RowMapper<Book>() {
			@Override
			public Book mapRow(ResultSet rs, int row) throws SQLException {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				return book;
			}
		});
	}

	@Override
	public List<Book> getAll() {
		return getJdbcTemplate().query(SELECT_ALL, new RowMapper<Book>() {
			@Override
			public Book mapRow(ResultSet rs, int row) throws SQLException {
				Book book = new Book(null, rs.getInt("book.id"), rs.getString("book.title"));
				Author author = new Author(rs.getInt("book.author_id"), rs.getString("author.name"), null);
				book.setAuthor(author);
				return book;
			}
		});
	}

	@Override
	public void create(Book book) {
		getJdbcTemplate().update(INSERT, book.getTitle(), book.getAuthor().getId());
	}

	@Override
	public void update(Book book) {
		Object[] params = {book.getTitle(), book.getAuthor().getId(), book.getId()};
		getJdbcTemplate().update(UPDATE,params);
	}

	@Override
	public void delete(Long id) {
		getJdbcTemplate().update(DELETE,id);
	}
}
