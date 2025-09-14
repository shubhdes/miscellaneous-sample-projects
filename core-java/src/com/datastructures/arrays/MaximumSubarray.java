package com.datastructures.arrays;

public class MaximumSubarray {

    private int solve(int[] arr, int n) {
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
            maxi = Math.max(maxi, sum);

            if (sum < 0) {
                sum = 0;
            }
        }
        return maxi;
    }
}
