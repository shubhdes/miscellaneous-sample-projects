package com.pattern.creational.abstractfactory;

public class Client {

	public static void main(String[] args) {
		ResourceFactory factory = new GoogleResourceFactory();
		Instance instance = factory.createInstance();
		System.out.println(instance);
		Storage storage = factory.createStorage();
		System.out.println(storage);
	}
}
