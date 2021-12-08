package com.datastructures.arrays;

import java.util.Arrays;

public class FindLowHigIndexInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 6, 5, 3, 1, 8, 7, 2, 4 };
		int[] output = find(input);
		System.out.println(Arrays.toString(output));
	}

	public static int[] find(int[] input) {
		int[] output = { -1, -1 };
		int low = 0;
		int high = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] <= input[low]) {
				low = i;
				output[0] = i;
			}
			if (input[i] >= input[high]) {
				high = i;
				output[1] = i;
			}
		}
		return output;
	}

}
