package com.pattern.behavioral.state;

public class PaidState implements OrderState {

	@Override
	public double handleCancellation() {
		return 50;
	}
}
