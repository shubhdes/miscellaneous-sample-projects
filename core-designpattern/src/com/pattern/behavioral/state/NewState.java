package com.pattern.behavioral.state;

public class NewState implements OrderState {

	@Override
	public double handleCancellation() {
		return 0;
	}

}
