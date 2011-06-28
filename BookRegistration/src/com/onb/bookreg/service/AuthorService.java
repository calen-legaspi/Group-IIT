package com.onb.bookreg.service;

import java.util.List;

import com.onb.bookreg.domain.Author;

public interface AuthorService {

	public abstract Author get(Long id);

	public abstract List<Author> getAll();

	public abstract void create(Author author);

	public abstract void update(Author author);

	public abstract void delete(Long id);

}