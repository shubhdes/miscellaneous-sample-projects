package com.pattern.behavioral.observer;

public class Client {

	public static void main(String[] args) {

		Order order = new Order();
		PriceObserver priceObserver = new PriceObserver();
		QuantityObserver quantityObserver = new QuantityObserver();

		order.attach(priceObserver);
		order.attach(quantityObserver);

		order.addItem(100);
		order.addItem(200);
		order.addItem(300);
		order.addItem(400);
		order.addItem(500);
	}
}
