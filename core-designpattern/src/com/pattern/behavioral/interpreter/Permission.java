package com.pattern.behavioral.interpreter;

public class Permission implements PermissionExpression {

	private String role;

	public Permission(String role) {
		this.role = role;
	}

	@Override
	public boolean interpret(User user) {
		return user.getRoles().contains(role);
	}
}
