package com.pattern.creational.prototype;

public class Client {

	public static void main(String[] args) throws CloneNotSupportedException {
		SwordsMan prototype = new SwordsMan();
		prototype.move(-10, 0, 0);
		prototype.attack();
		System.out.println(prototype);

		SwordsMan swordsMan = (SwordsMan) prototype.clone();
		System.out.println(swordsMan);
	}
}
