package com.pattern.behavioral.interpreter;

public interface PermissionExpression {

	boolean interpret(User user);
}
