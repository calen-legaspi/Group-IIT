package com.onb.bookreg.service;

import java.util.List;

import com.onb.bookreg.domain.Book;

public interface BookService {

	public abstract Book get(Long id);

	public abstract List<Book> getAll();

	public abstract void create(Book book);

	public abstract void update(Book book);

	public abstract void delete(Long id);

}