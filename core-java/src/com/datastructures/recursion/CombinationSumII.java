package com.datastructures.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumII {

    private void solve(int[] nums, int n, int index, int target,
                       List<Integer> tempresult, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(tempresult));
            return;
        }

        for (int i = index; i < n; i++) {

            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] > target) {
                break;
            }

            tempresult.add(nums[i]);
            solve(nums, n, i + 1, target - nums[i], tempresult, result);

            tempresult.remove(tempresult.size() - 1);
        }
    }
}
