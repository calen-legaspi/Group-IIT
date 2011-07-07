package com.onb.shoppingcart.domain;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class User implements Serializable {
	private int id;
	private String username = "";
	private String password = "";
	private Role role;
	private List<Order> orders;

	public User() {
		super();
	}

	public User(int id, String username, String password, Role role, List<Order> orders) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.orders = orders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
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
		if (obj == null || !(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		if (id == 0 && other.id == 0) {
			return username.equals(other.username);
		}
		return id == other.id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", role=" + role + "]";
	}

}
