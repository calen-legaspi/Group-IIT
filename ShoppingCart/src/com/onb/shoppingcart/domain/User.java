package com.onb.shoppingcart.domain;

import java.util.Set;

public class User {
	private int id;
	private String username;
	private String password;
	private Role role;
	private Set<Order> orders;
}
