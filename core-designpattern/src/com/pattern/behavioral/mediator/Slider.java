package com.pattern.behavioral.mediator;

public class Slider implements UIControl {

	private UIMediator mediator;

	private String value;

	public Slider(UIMediator mediator) {
		this.mediator = mediator;
		mediator.register(this);
	}

	@Override
	public void controlChanged(UIControl control) {
		this.value = control.getValue();
	}

	@Override
	public String getValue() {
		return value;
	}
}
