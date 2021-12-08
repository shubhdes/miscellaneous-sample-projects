package com.datastructures.arrays;

import java.util.Arrays;

public class ArraySortingUsingInsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 6, 5, 3, 1, 8, 7, 2, 4 };
		sort(input);
		System.out.println(Arrays.toString(input));
	}

	public static void sort(int[] input) {
		int key = 0;
		int j = 0;
		for (int i = 1; i < input.length; i++) {
			key = input[i];
			j = i - 1;
			while (j >= 0 && key < input[j]) {
				input[j + 1] = input[j];
				j = j - 1;
			}
			input[j + 1] = key;
		}
	}
}
