package com.datastructures.arrays;

import java.util.HashSet;

public class ContainsDuplicateElementsInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 1, 2, 3, 1 };
		System.out.println(duplicate(input));
	}

	public static boolean duplicate(int[] input) {
		boolean output = false;
		HashSet<Integer> elementSet = new HashSet<>();
		for (int i = 0; i < input.length; i++) {
			if (elementSet.contains(input[i])) {
				output = true;
				break;
			}
			elementSet.add(input[i]);
		}
		return output;
	}
}
