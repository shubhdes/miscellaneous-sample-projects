package com.datastructures.v2.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumI {

    private void solve(int[] nums, int n, int index, int target,
                       List<Integer> tempresult, List<List<Integer>> result) {

        if (index == n) {
            if (target == 0) {
                result.add(new ArrayList<>(tempresult));
            }
            return;
        }

        if (nums[index] <= target) {
            tempresult.add(nums[index]);
            solve(nums, n, index, target - nums[index], tempresult, result);

            tempresult.remove(tempresult.size() - 1);
        }
        solve(nums, n, index + 1, target, tempresult, result);
    }
}
