package com.onb.shoppingcart.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Role implements Serializable {
	private int id;
	private String roleType = "";

	public Role() {
		super();
	}

	public Role(int id, String roleType) {
		super();
		this.id = id;
		this.roleType = roleType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
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
		if (obj == null || !(obj instanceof Role)) {
			return false;
		}
		Role other = (Role) obj;
		if (id == 0 && other.id == 0) {
			return roleType.equals(other.roleType);
		}
		return id == other.id;
	}

	@Override
	public String toString() {
		return roleType;
	}
	
}
