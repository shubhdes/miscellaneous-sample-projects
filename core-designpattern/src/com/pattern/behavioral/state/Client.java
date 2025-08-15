package com.pattern.behavioral.state;

public class Client {

	public static void main(String[] args) {

		Order order = new Order();
		order.paymentSuccessful();
		order.dispatched();
		double charges = order.cancel();
		System.out.println("Cancellation charges " + charges);
	}
}
