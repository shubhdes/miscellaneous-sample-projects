package com.datastructures.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    private void solve(int num, int target, int maxsize,
                       List<Integer> tempresult, List<List<Integer>> result) {

        if (target == 0 && tempresult.size() == maxsize) {
            result.add(new ArrayList<>(tempresult));
            return;
        }

        if (num == 10 || tempresult.size() > maxsize) {
            return;
        }

        for (int i = num; i < 10; i++) {

            if (i > target) {
                break;
            }

            tempresult.add(i);
            solve(i + 1, target - i, maxsize, tempresult, result);

            tempresult.remove(tempresult.size() - 1);
        }
    }
}
