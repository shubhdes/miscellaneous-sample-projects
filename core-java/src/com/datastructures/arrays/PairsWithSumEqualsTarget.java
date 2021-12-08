package com.datastructures.arrays;

import java.util.HashSet;

public class PairsWithSumEqualsTarget {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 1, 10, 7, 9, 15, 6, 12, 4, };
		int target = 16;
		findPairs(input, target);
	}

	public static void findPairs(int[] input, int target) {
		if (input.length <= 1) {
			return;
		}
		int temp = 0;
		HashSet<Integer> elementSet = new HashSet<>();
		for (int i = 0; i < input.length; i++) {
			temp = target - input[i];
			if (elementSet.contains(temp)) {
				System.out.println("(" + temp + "," + input[i] + ")");
			}
			elementSet.add(input[i]);
		}
	}
}
