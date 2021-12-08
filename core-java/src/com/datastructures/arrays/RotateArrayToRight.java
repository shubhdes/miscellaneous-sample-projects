package com.datastructures.arrays;

import java.util.Arrays;

public class RotateArrayToRight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 1, 2, 3, 4, 5 };
		int step = 11;
		int[] output = rotate(input, step);
		System.out.println(Arrays.toString(output));
	}

	public static int[] rotate(int[] input, int step) {
		if (step == 0 || input.length == step) {
			return input;
		}
		int[] output = new int[input.length];
		int temp = 0;
		int lastIndex = input.length - 1;
		for (int i = 0; i < input.length; i++) {
			temp = i + step;
			if (temp > lastIndex) {
				temp = temp % input.length;
			}
			output[temp] = input[i];
		}
		return output;
	}

}
