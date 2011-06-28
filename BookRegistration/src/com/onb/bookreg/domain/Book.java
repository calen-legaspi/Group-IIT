package com.onb.bookreg.domain;

public class Book {
	private int id;
	private String title;
	private Author author;
	
	public Book() {}
	
	public Book(Author author, int id, String title) {
		super();
		this.author = author;
		this.id = id;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
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
		return id == ((Book)obj).id;
	}

	@Override
	public String toString() {
		return title+" by:"+author;
	}
}
