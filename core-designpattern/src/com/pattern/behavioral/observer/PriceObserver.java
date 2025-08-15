package com.pattern.behavioral.observer;

public class PriceObserver implements OrderObserver {

	@Override
	public void updated(Order order) {

		if (order.getItemCost() >= 1000) {
			System.out.println("Order is eligible for discount");
		}
	}
}
