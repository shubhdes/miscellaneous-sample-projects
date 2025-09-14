package com.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingIntervals {

    private int[][] solve(int[][] nums, int n) {

        Arrays.sort(nums, Comparator.comparingInt(subnums -> subnums[0]));

        ArrayList<int[]> tempresult = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (tempresult.isEmpty() || nums[i][0] > tempresult.get(tempresult.size() - 1)[1]) {
                tempresult.add(nums[i]);
            }
            else {
                tempresult.get(tempresult.size() - 1)[1] = Math.max(
                        tempresult.get(tempresult.size() - 1)[1], nums[i][1]);
            }
        }

        int[][] result = new int[tempresult.size()][2];
        for (int i = 0; i < tempresult.size(); i++) {
            result[i] = tempresult.get(i);
        }

        return result;
    }
}
