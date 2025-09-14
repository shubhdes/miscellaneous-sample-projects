package com.datastructures.arrays;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    private int solve(int[] nums, int n) {

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        int maxi = -1;
        for (int i = 0; i < n; i++) {

            if (set.contains(nums[i] - 1)) {
                continue;
            }

            int t = nums[i];
            int len = 0;
            while (set.remove(t)) {
                len++;
                t = t + 1;
            }
            maxi = Math.max(maxi, len);
        }

        return maxi;
    }
}
