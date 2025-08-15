package com.pattern.creational.abstractfactory;

public interface ResourceFactory {

	Instance createInstance();

	Storage createStorage();
}
