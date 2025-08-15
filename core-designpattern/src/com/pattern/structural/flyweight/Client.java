package com.pattern.structural.flyweight;

import com.pattern.structural.flyweight.ErrorMessageFactory.ErrorType;

public class Client {

	public static void main(String[] args) {
		ErrorMessage errorMessage = ErrorMessageFactory.getError(ErrorType.GenericSystemError);
		System.out.println(errorMessage.getText("E231001"));
	}
}
