package com.datastructures.v2.arrays;

public class NextPermutation {

    private void solve(int[] nums, int n) {

        int bp = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                bp = i;
                break;
            }
        }

        if (bp == -1) {
            rotate(nums, n, 0, n - 1);
            return;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > nums[bp]) {
                swap(nums, i, bp);
                break;
            }
        }

        rotate(nums, n, bp + 1, n - 1);
    }

    private void rotate(int[] nums, int n, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
