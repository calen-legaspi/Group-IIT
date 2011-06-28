package com.onb.bookreg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onb.bookreg.dao.AuthorDAO;
import com.onb.bookreg.domain.Author;
import com.onb.bookreg.service.AuthorService;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {
	
	private AuthorDAO authorDAO;
	
	@Autowired
	public void setAuthorDAO(AuthorDAO authorDAO) {
		this.authorDAO = authorDAO;
	}

	@Override
	public Author get(Long id) {
		return authorDAO.get(id);
	}

	@Override
	public List<Author> getAll() {
		return authorDAO.getAll();
	}

	@Override
	public void create(Author author) {
		authorDAO.create(author);
	}

	@Override
	public void update(Author author) {
		authorDAO.update(author);
	}

	@Override
	public void delete(Long id) {
		authorDAO.delete(id);
	}
}
