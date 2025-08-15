package com.pattern.structural.decorator;

public class Client {

	public static void main(String[] args) {
		Message message = new TextMessage("welcome");
		Message decorator = new Base64EncodedMessage(message);
		System.out.println(decorator.getContent());
	}
}
