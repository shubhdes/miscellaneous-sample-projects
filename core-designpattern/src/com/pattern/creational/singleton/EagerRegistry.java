package com.pattern.creational.singleton;

public final class EagerRegistry {

	private static final EagerRegistry INSTANCE = new EagerRegistry();

	private EagerRegistry() {

	}

	public static EagerRegistry getInstance() {
		return INSTANCE;
	}
}
