package com.pattern.creational.abstractfactory;

public class AwsResourceFactory implements ResourceFactory {

	@Override
	public Instance createInstance() {
		return new EC2Instance();
	}

	@Override
	public Storage createStorage() {
		return new S3Storage();
	}
}
