package com.datastructures.arrays;

import java.util.Arrays;

public class ArraySortingUsingMergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 3, 30, 34, 5, 9 };// { 6, 5, 3, 1, 8, 7, 2, 4 };
		int[] output = sort(input);
		System.out.println(Arrays.toString(output));
	}

	public static int[] sort(int[] input) {
		if (input.length == 1) {
			return input;
		}
		int k = 0;
		int mid = input.length / 2;
		int[] left = new int[mid];
		int i = 0;
		while (i < left.length) {
			left[i] = input[k];
			i++;
			k++;
		}
		int[] right = new int[input.length - mid];
		int j = 0;
		while (j < right.length) {
			right[j] = input[k];
			j++;
			k++;
		}
		return mergeSort(sort(left), sort(right));
	}

	public static int[] mergeSort(int[] left, int[] right) {
		int[] output = new int[left.length + right.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				output[k] = left[i];
				i++;
				k++;
			} else {
				output[k] = right[j];
				j++;
				k++;
			}
		}
		while (i < left.length) {
			output[k] = left[i];
			i++;
			k++;
		}
		while (j < right.length) {
			output[k] = right[j];
			j++;
			k++;
		}
		return output;
	}
}
