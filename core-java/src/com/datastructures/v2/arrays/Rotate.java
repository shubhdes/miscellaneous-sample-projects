package com.datastructures.v2.arrays;

public class Rotate {

    private void solve(int[] nums, int n, int k) {
        rotateright(nums, n, k);
    }

    private void rotateleft(int[] nums, int n, int k) {
        k = k % n;
        rotate(nums, n, 0, k - 1);
        rotate(nums, n, k, n - 1);
        rotate(nums, n, 0, n - 1);
    }

    private void rotateright(int[] nums, int n, int k) {
        k = k % n;
        rotate(nums, n, n - k, n - 1);
        rotate(nums, n, 0, n - k - 1);
        rotate(nums, n, 0, n - 1);
    }

    private void rotate(int[] nums, int n, int start, int end) {
        int t;
        while (start < end) {
            t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start++;
            end--;
        }
    }
}
