package com.onb.shoppingcart.domain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("serial")
public class Category implements Serializable {
	private int id;
	private String name = "";
	private List<Product> products = new LinkedList<Product>();
	
	public Category() {
		super();
	}
	
	public Category(int id) {
		this();
		this.id = id;
	}

	public Category(int id, String name, List<Product> products) {
		this(id);
		this.name = name;
		this.products = products;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
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
		if(obj==null || obj.getClass() != this.getClass()) {
			return false;
		}
		Category other = (Category) obj;
		if(other.id == 0 && id == 0) {
			return name.equals(other.name);
		}
		return id == other.id;
	}

	@Override
	public String toString() {
		return name;
	}
	
	public int getSize() {
		return products.size();
	}
}
