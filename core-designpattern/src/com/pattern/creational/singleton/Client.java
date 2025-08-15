package com.pattern.creational.singleton;

public class Client {

	public static void main(String[] args) {

		System.out.print("Are both instances same? " + (EagerRegistry.getInstance() == EagerRegistry.getInstance()));
		System.out.print("Are both instances same? " + (LazyRegistry.getInstance() == LazyRegistry.getInstance()));
	}
}
