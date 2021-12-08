package com.datastructures.arrays;

import java.util.Arrays;

public class FizzBuzzDivisibilityProblem {

	private static final String FIZZ = "Fizz";

	private static final String BUZZ = "Buzz";

	private static final String FIZZBUZZ = "FizzBuzz";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 5;
		String[] output = solve(input);
		System.out.println(Arrays.toString(output));
	}

	public static String[] solve(int input) {
		String[] output = new String[input];
		int index = 0;
		for (int i = 1; i <= input; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				output[index] = FIZZBUZZ;
			} else if (i % 3 == 0) {
				output[index] = FIZZ;
			} else if (i % 5 == 0) {
				output[index] = BUZZ;
			} else {
				output[index] = String.valueOf(i);
			}
			index++;
		}
		return output;
	}
}
