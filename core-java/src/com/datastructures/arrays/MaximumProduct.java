package com.datastructures.arrays;

public class MaximumProduct {

    private int solve(int[] arr, int n) {

        int prefixprod = 1;
        int suffixprod = 1;
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            if (prefixprod == 0) {
                prefixprod = 1;
            }
            if (suffixprod == 0) {
                suffixprod = 1;
            }

            prefixprod = prefixprod * arr[i];
            suffixprod = suffixprod * arr[n - 1 - i];

            maxi = Math.max(maxi, Math.max(prefixprod, suffixprod));
        }
        return maxi;
    }
}
