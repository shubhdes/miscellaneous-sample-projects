package com.datastructures.recursion;

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
            swap(nums, index, i);
            solve(nums, n, index + 1, result);
            swap(nums, index, i);
        }
    }


    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
