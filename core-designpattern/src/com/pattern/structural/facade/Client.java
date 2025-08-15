package com.pattern.structural.facade;

public class Client {

	public static void main(String[] args) {
		EmailFacade facade = new EmailFacade();
		facade.sendOrderEmail(new Order("ORD1001", 7501.35d));
	}
}
