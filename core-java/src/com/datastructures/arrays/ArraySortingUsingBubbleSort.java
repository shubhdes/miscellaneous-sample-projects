package com.datastructures.arrays;

import java.util.Arrays;

public class ArraySortingUsingBubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 6, 5, 3, 1, 8, 7, 2, 4 };
		sort(input);
		System.out.println(Arrays.toString(input));
	}

	public static void sort(int[] input) {
		int temp = 0;
		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				if (input[i] > input[j]) {
					temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			}
		}
	}
}
