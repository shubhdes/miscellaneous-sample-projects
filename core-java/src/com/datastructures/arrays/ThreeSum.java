package com.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    private List<List<Integer>> solve(int[] arr, int n) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {

            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = n - 1;

            while (j < k) {

                int sum = arr[i] + arr[j] + arr[k];
                if (sum > 0) {
                    k--;
                }
                else if (sum < 0) {
                    j++;
                }
                else {
                    result.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;

                    while (j < k && arr[j] == arr[j - 1]) {
                        j++;
                    }

                    while (j < k && arr[k] == arr[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return result;
    }
}
