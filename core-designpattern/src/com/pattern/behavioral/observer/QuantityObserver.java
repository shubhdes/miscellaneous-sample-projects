package com.pattern.behavioral.observer;

public class QuantityObserver implements OrderObserver {

	@Override
	public void updated(Order order) {

		if (order.getCount() >= 3) {
			System.out.println("Order is eligible for free shipping");
		}
	}
}
