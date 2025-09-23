package com.datastructures.arrays;

public class QuickSort {

    private void sort(int[] nums, int low, int high) {
        if (low < high) {
            int pi = getpivotindex(nums, low, high);
            sort(nums, low, pi - 1);
            sort(nums, pi + 1, high);
        }
    }

    private int getpivotindex(int[] nums, int low, int high) {
        int p = nums[low];
        int i = low;
        int j = high;

        while (i < j) {

//            while (nums[i] <= p && i <= high - 1) {
            while (i <= high && nums[i] <= p) {
                i++;
            }
//            while (nums[j] > p && j >= low + 1) {
            while (j >= low && nums[j] > p) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }

        swap(nums, low, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
