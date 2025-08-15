package com.pattern.behavioral.iterator;

public class Client {

	public static void main(String[] args) {

		ThemeColor themeColor = new ThemeColor();
		Iterator iterator = themeColor.getIterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
