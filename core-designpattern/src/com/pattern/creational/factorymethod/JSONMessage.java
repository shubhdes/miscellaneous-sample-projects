package com.pattern.creational.factorymethod;

public class JSONMessage extends Message {

	@Override
	public String getContent() {
		return "{\"greetings\":\"welcome\"}";
	}

}
