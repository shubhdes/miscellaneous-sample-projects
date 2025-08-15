package com.pattern.behavioral.interpreter;

public class PermissionExpressionBuilder {

	public PermissionExpression build(Report report) {

		String[] tokens = report.getRule().split(" ");

		if (tokens.length == 1) {
			return new Permission(tokens[0]);
		}

		if ("and".equals(tokens[1])) {
			return new AndExpression(new Permission(tokens[0]), new Permission(tokens[2]));
		} else if ("or".equals(tokens[1])) {
			return new OrExpression(new Permission(tokens[0]), new Permission(tokens[2]));
		}

		throw new IllegalArgumentException();
	}
}
