package com.datastructures.arrays;

public class MaximumProfitInStockMarket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 10, 22, 5, 75, 65, 80 };
		System.out.println(maxProfit(input));
	}

	public static int maxProfit(int[] input) {
		if (input.length <= 1) {
			return 0;
		}
		int temp = 0;
		int lowestPrice = input[0];
		int maxProfit = 0;
		for (int i = 1; i < input.length; i++) {
			if (input[i] < lowestPrice) {
				lowestPrice = input[i];
			} else {
				temp = input[i] - lowestPrice;
				if (temp > maxProfit) {
					maxProfit = temp;
				}
			}
		}
		return maxProfit;
	}

}
