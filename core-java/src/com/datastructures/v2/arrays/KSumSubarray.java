package com.datastructures.v2.arrays;

import java.util.HashMap;

public class KSumSubarray {

    private int solve(int[] nums, int n, int k) {

        HashMap<Integer, Integer> prefixsummap = new HashMap<>();
        prefixsummap.put(0, 1);

        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {

            sum = sum + nums[i];

            int t = prefixsummap.getOrDefault(sum - k, 0);
            count = count + t;

            prefixsummap.put(sum, prefixsummap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
