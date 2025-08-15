package com.pattern.creational.abstractfactory;

public class GoogleResourceFactory implements ResourceFactory {

	@Override
	public Instance createInstance() {
		return new GCEInstance();
	}

	@Override
	public Storage createStorage() {
		return new GCStorage();
	}
}
