package com.datastructures.arrays;

public class StringReversalUsingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "Welcome to datastructures and algorithms";
		System.out.println(reverse(input));
	}

	public static String reverse(String input) {
		char[] inputChars = new char[input.length()];
		for (int i = 0; i < input.length(); i++) {
			inputChars[i] = input.charAt(i);
		}

		StringBuilder outputbuffer = new StringBuilder();
		int lastIdx = inputChars.length - 1;
		for (int i = lastIdx; i >= 0; i--) {
			outputbuffer.append(inputChars[i]);
		}
		String output = outputbuffer.toString();
		return output;
	}
}
