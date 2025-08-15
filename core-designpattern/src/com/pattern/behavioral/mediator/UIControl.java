package com.pattern.behavioral.mediator;

public interface UIControl {

	void controlChanged(UIControl control);

	String getValue();
}
