package com.datastructures.arrays;

import java.util.Arrays;

public class ArraySortingUsingQuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 6, 5, 3, 1, 8, 7, 2, 4 };
		int low = 0;
		int high = input.length - 1;
		sort(input, low, high);
		System.out.println(Arrays.toString(input));
	}

	public static void sort(int[] input, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(input, low, high);
			sort(input, low, pivotIndex - 1);
			sort(input, pivotIndex + 1, high);
		}
	}
//
//	public static int partition(int[] input, int low, int high) {
//		int pivot = input[high];
//		int pivotIndex = low - 1;
//		int temp = 0;
//		for (int i = low; i < high; i++) {
//			if (pivot > input[i]) {
//				pivotIndex++;
//				temp = input[i];
//				input[i] = input[pivotIndex];
//				input[pivotIndex] = temp;
//			}
//		}
//		pivotIndex++;
//		temp = input[high];
//		input[high] = input[pivotIndex];
//		input[pivotIndex] = temp;
//		return pivotIndex;
//	}
//	

	public static int partition(int[] nums, int low, int high) {
		int pivot = nums[high];
		int pivotIndex = low - 1;
		int temp = 0;
		for (int i = low; i < high; i++) {
			if (nums[i] > pivot) {
				pivotIndex++;
				temp = nums[i];
				nums[i] = nums[pivotIndex];
				nums[pivotIndex] = temp;
			}
		}
		pivotIndex++;
		temp = nums[high];
		nums[high] = nums[pivotIndex];
		nums[pivotIndex] = temp;
		return pivotIndex;
	}
}
