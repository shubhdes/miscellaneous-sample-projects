package com.datastructures.arrays;

import java.util.HashMap;

public class KSumSubarray {

    private int solve(int[] arr, int n, int k) {

        HashMap<Integer, Integer> prefixsummap = new HashMap<>();
        prefixsummap.put(0, 1);

        int count = 0;
        int prefixsum = 0;
        for (int  i = 0; i < n; i++) {
            prefixsum = prefixsum + arr[i];
            count = count + prefixsummap.getOrDefault(prefixsum - k, 0);
            prefixsummap.put(prefixsum, prefixsummap.getOrDefault(prefixsum, 0) + 1);
        }

        return count;
    }
}
