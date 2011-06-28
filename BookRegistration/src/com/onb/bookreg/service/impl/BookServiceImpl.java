package com.onb.bookreg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onb.bookreg.dao.BookDAO;
import com.onb.bookreg.domain.Book;
import com.onb.bookreg.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {
	
	private BookDAO bookDAO;
	
	@Autowired
	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	@Override
	public Book get(Long id) {
		return bookDAO.get(id);
	}

	@Override
	public List<Book> getAll() {
		return bookDAO.getAll();
	}

	@Override
	public void create(Book book) {
		bookDAO.create(book);
	}

	@Override
	public void update(Book book) {
		bookDAO.update(book);
	}

	@Override
	public void delete(Long id) {
		bookDAO.delete(id);
	}
}
