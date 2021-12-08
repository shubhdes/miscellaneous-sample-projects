package com.datastructures.recursion;

public class FactorialUsingRecursion {

	public static void main(String[] args) {
		System.out.println(factorial(5));
		System.out.println(factorial(7));
	}

	public static int factorial(int input) {
		if (input == 1) {
			return input;
		}
		return input * factorial(input - 1);
	}
}
