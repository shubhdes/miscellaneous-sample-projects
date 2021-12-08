package com.datastructures.recursion;

public class FibonacciUsingRecursion {

	private static int firstNum = 0;

	private static int secondNum = 1;

	public static void main(String[] args) {
		System.out.println(firstNum);
		System.out.println(secondNum);
		fibonacci(5);
	}

	public static void fibonacci(int count) {
		if (count == 2) {
			return;
		}
		int nextNum = firstNum + secondNum;
		System.out.println(nextNum);
		firstNum = secondNum;
		secondNum = nextNum;
		fibonacci(count - 1);
	}
}
