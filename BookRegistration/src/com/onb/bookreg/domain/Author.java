package com.onb.bookreg.domain;

import java.util.List;

public class Author {
	private int id;
	private String name;
	private List<Book> books;
	
	public Author(){}
	
	public Author(int id, String name, List<Book> books) {
		this.books = books;
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public void addBook(Book book) {
		this.books.add(book);
		book.setAuthor(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		return id == ((Author)obj).id;
	}

	@Override
	public String toString() {
		return name;
	}
}
