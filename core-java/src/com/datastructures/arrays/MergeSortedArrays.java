package com.datastructures.arrays;

import java.util.Arrays;

public class MergeSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input0 = { 1, 7, 9, 12, 17 };
		int[] input1 = { 4, 6, 9, 11, 20 };
		int[] output = merge(input0, input1);
		System.out.println(Arrays.toString(output));
	}

	public static int[] merge(int[] input0, int[] input1) {
		if (input0.length == 0) {
			return input1;
		}
		if (input1.length == 0) {
			return input0;
		}
		int[] output = new int[input0.length + input1.length];
		int index = 0;
		int i = 0, j = 0;
		while (i < input0.length && j < input1.length) {
			int input0Element = input0[i];
			int input1Element = input1[j];
			if (input0Element < input1Element) {
				output[index] = input0Element;
				i++;
			} else {
				output[index] = input1Element;
				j++;
			}
			++index;
		}
		while (i < input0.length) {
			int input0Element = input0[i];
			output[index] = input0Element;
			i++;
			++index;
		}
		while (j < input1.length) {
			int input1Element = input1[j];
			output[index] = input1Element;
			j++;
			++index;
		}
		return output;
	}
}
