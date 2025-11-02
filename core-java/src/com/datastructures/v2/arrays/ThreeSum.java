package com.datastructures.v2.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    private List<List<Integer>> solve(int[] nums, int n, long t) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n ; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = n - 1;

            while (j < k) {

                long sum = nums[i] + nums[j] + nums[k];
                if (sum < t) {
                    j++;
                }
                else if (sum > t) {
                    k--;
                }
                else {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }

        return result;
    }
}
