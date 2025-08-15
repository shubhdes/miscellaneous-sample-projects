package com.pattern.creational.factorymethod;

public class JSONMessageCreator extends MessageCreator {

	@Override
	public Message getMessage() {
		return new JSONMessage();
	}
}
