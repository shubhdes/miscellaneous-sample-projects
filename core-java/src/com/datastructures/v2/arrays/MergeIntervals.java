package com.datastructures.v2.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

    private int[][] solve(int[][] nums, int n) {

        Arrays.sort(nums, Comparator.comparingInt(e -> e[0]));

        ArrayList<int[]> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            if (temp.isEmpty() || nums[i][0] > temp.get(temp.size() - 1)[1]) {
                temp.add(nums[i]);
            }
            else {
                temp.get(temp.size() - 1)[1] = Math.max(temp.get(temp.size() - 1)[1], nums[i][1]);
            }
        }

        int[][] result = new int[temp.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = temp.get(i);
        }

        return result;
    }
}
