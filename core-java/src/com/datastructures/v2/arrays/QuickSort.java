package com.datastructures.v2.arrays;

public class QuickSort {

    private void quicksort(int[] nums, int low, int high) {
        if (low < high) {
            int pi = getpivotindex(nums, low, high);
            quicksort(nums, low, pi - 1);
            quicksort(nums, pi + 1, high);
        }
    }

    private int getpivotindex(int[] nums, int low, int high) {

        int p = nums[low];
        int i = low;
        int j = high;

        while (i < j) {

            while (i <= high && nums[i] <= p) {
                i++;
            }

            while (j >= low && nums[i] > p) {
                j--;
            }

            swap(nums, i, j);
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
