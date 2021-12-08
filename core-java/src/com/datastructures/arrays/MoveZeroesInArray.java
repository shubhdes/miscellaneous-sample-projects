package com.datastructures.arrays;

import java.util.Arrays;

public class MoveZeroesInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 10, 15, 0, 1, 0, 0, 3, 12, 0, 0, 7, 5 };
		move(input);
		System.out.println(Arrays.toString(input));
	}

	public static void move(int[] input) {
		if (input.length <= 1) {
			return;
		}
		int count = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] != 0) {
				input[count] = input[i];
				count++;
			}
		}

		while (count < input.length) {
			input[count] = 0;
			count++;
		}
	}
}
