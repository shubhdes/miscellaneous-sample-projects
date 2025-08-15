package com.pattern.behavioral.state;

public class InTransitState implements OrderState {

	@Override
	public double handleCancellation() {
		return 100;
	}
}
