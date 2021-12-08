package com.datastructures.arrays;

public class FindKSmallestElementInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] input = { 6, 5, 3, 1, 8, 7, 2, 4 };
		int[] input = { 5, 2, 9, 17, 12, 15, 4, 8, 19 };
		int low = 0;
		int high = input.length - 1;
		System.out.println(sort(input, low, high, 2));
	}

	public static int sort(int[] input, int low, int high, int k) {
		if (k > input.length) {
			return -1;
		}
		int pivotIndex = partition(input, low, high);
		if (pivotIndex == k - 1) {
			return input[pivotIndex];
		} else if (pivotIndex > k - 1) {
			return sort(input, low, pivotIndex - 1, k);
		} else {
			return sort(input, pivotIndex + 1, high, k);
		}
	}

	public static int partition(int[] input, int low, int high) {
		int pivot = input[high];
		int pivotIndex = low - 1;
		int temp = 0;
		for (int i = low; i < high; i++) {
			if (pivot > input[i]) {
				pivotIndex++;
				temp = input[i];
				input[i] = input[pivotIndex];
				input[pivotIndex] = temp;
			}
		}
		pivotIndex++;
		temp = input[high];
		input[high] = input[pivotIndex];
		input[pivotIndex] = temp;
		return pivotIndex;
	}
}
