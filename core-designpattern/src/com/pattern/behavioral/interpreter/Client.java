package com.pattern.behavioral.interpreter;

import java.util.Collections;

public class Client {

	public static void main(String[] args) {

		Report report = new Report("admin or durga");
		PermissionExpressionBuilder builder = new PermissionExpressionBuilder();
		PermissionExpression expression = builder.build(report);

		User user = new User(Collections.singletonList("durga"));
		System.out.println(expression.interpret(user));
	}
}
