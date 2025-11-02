package com.datastructures.v2.arrays;

public class DNFSort {

    private void solve(int[] nums, int n) {

        int low = 0;
        int mid = 0;
        int high = n - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, mid, low);
                low++;
                mid++;
            }
            else if (nums[mid] == 1) {
                mid++;
            }
            else {
                swap(nums, mid, high);
                mid++;
                high++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
