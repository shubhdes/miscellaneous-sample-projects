package com.pattern.behavioral.state;

public class DeliveredState implements OrderState {

	@Override
	public double handleCancellation() {
		return 150;
	}
}
