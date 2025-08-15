package com.pattern.creational.singleton;

public final class LazyRegistry {

//	private static volatile LazyRegistry INSTANCE;

	private LazyRegistry() {

	}

//	public static LazyRegistry getInstance() {
//		if (null == INSTANCE) {
//			synchronized (LazyRegistry.class) {
//				if (null == INSTANCE) {
//					INSTANCE = new LazyRegistry();
//				}
//			}
//		}
//		return INSTANCE;
//	}

	public static LazyRegistry getInstance() {
		return Registry.INSTANCE;
	}

	private static class Registry {
		static volatile LazyRegistry INSTANCE = new LazyRegistry();
	}
}
