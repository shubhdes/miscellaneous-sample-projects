package com.datastructures.v2.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    private List<List<Integer>> solve(int[] nums, int n, long t) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n ; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int k = j + 1;
                int l = n - 1;

                while (k < l) {

                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum < t) {
                        k++;
                    }
                    else if (sum > t) {
                        l--;
                    }
                    else {
                        result.add(List.of(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }

                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    }
                }
            }
        }
        return result;
    }
}
