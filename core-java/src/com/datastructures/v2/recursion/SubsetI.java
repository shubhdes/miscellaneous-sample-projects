package com.datastructures.v2.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetI {

    private void solve(int[] nums, int n, int index,
                       List<Integer> tempresult, List<List<Integer>> result) {

        if (index == n) {
            result.add(new ArrayList<>(tempresult));
            return;
        }

        tempresult.add(nums[index]);
        solve(nums, n, index + 1, tempresult, result);

        tempresult.remove(tempresult.size() - 1);
        solve(nums, n, index + 1, tempresult, result);
    }
}
