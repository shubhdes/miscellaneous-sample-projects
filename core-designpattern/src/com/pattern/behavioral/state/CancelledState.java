package com.pattern.behavioral.state;

public class CancelledState implements OrderState {

	@Override
	public double handleCancellation() {
		throw new IllegalStateException();
	}

}
