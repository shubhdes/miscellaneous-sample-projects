package com.datastructures.v2.arrays;

public class MoveZeroes {

    private void solve(int[] nums, int n) {

        int i = 0;
        while (i < n) {
            if (nums[i] == 0) {
                break;
            }
            i++;
        }
        int j = i + 1;

        while (j < n) {
            if (nums[j] != 0) {
                swap(nums, i, j);
                i++;
            }
            j++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
