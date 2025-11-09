package com.datastructures.v2.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetII {

    private void solve(int[] nums, int n, int index,
                       List<Integer> tempresult, List<List<Integer>> result) {

        result.add(new ArrayList<>(tempresult));

        for (int i = index; i < n; i++) {

            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            tempresult.add(nums[i]);
            solve(nums, n, i + 1, tempresult, result);

            tempresult.remove(tempresult.size() - 1);
        }
    }
}
