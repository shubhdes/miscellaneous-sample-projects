package com.pattern.behavioral.interpreter;

import java.util.List;

public class User {

	private List<String> roles;

	public User(List<String> roles) {
		this.roles = roles;
	}

	public List<String> getRoles() {
		return roles;
	}
}
