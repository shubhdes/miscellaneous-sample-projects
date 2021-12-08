package com.datastructures.arrays;

public class MaximumSumOfSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maximumSum(input));
	}

	public static int maximumSum(int[] input) {
		if (input.length == 0) {
			return 0;
		}
		int currSum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < input.length; i++) {
			currSum = currSum + input[i];
			if (currSum < 0) {
				currSum = 0;
			} else if (currSum > maxSum) {
				maxSum = currSum;
			}
		}
		return maxSum;
	}
}
