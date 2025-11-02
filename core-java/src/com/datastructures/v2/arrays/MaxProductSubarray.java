package com.datastructures.v2.arrays;

public class MaxProductSubarray {

    private int solve(int[] nums, int n) {

        int maxi = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;
        for (int i = 0; i < n; i++) {

            if (prefix == 0) {
                prefix = 1;
            }

            if (suffix == 0) {
                suffix = 1;
            }

            prefix = prefix * nums[i];
            suffix = suffix * nums[ n - 1 - i];

            maxi = Math.max(maxi, Math.max(prefix, suffix));
        }

        return maxi;
    }
}
