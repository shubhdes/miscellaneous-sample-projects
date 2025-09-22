package com.datastructures.arrays;

import java.util.HashMap;

public class KDivisibleSumSubarray {

    private int solve(int[] nums, int n, int k) {

        HashMap<Integer, Integer> remmap = new HashMap<>();
        remmap.put(0, 1);

        int count = 0;
        int sum = 0;
        int rem = 0;
        for (int i = 0; i < n; i++) {

            sum = sum + nums[i];
            rem = sum % k;

            if (rem < 0) {
                rem = rem + k;
            }

            count = count + remmap.getOrDefault(rem, 0);
            remmap.put(rem, remmap.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}
