package com.datastructures.v2.arrays;

public class MaxSumSubarray {

    private int solve(int[] nums, int n) {

        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];
            maxi = Math.max(maxi, sum);
            if (sum < 0) {
                sum = 0;
            }
        }

        return maxi;
    }
}
