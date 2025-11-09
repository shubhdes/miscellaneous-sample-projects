package com.datastructures.v2.recursion;

import java.util.ArrayList;
import java.util.List;

public class AllPermutations {

    private void solve(int[] nums, int n, int index, List<List<Integer>> result) {

        if (index == n) {
            List<Integer> tempresult = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                tempresult.add(nums[i]);
            }
            result.add(tempresult);
            return;
        }

        for (int i = index; i < n; i++) {
            swap(nums, i, index);
            solve(nums, n, index + 1, result);

            swap(nums, i, index);
        }
    }


    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
