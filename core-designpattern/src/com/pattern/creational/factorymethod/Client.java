package com.pattern.creational.factorymethod;

public class Client {

	public static void main(String[] args) {
		MessageCreator creator = new JSONMessageCreator();
		Message message = creator.getMessage();
		System.out.println(message.getContent());
	}
}
