package com.pattern.behavioral.state;

public class Order {

	private OrderState state;

	public Order() {
		this.state = new NewState();
	}

	public double cancel() {
		double charges = state.handleCancellation();
		this.state = new CancelledState();
		return charges;
	}

	public void paymentSuccessful() {
		this.state = new PaidState();
	}

	public void dispatched() {
		this.state = new InTransitState();
	}

	public void delivered() {
		this.state = new DeliveredState();
	}
}
