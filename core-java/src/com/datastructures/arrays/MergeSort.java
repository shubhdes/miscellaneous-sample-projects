package com.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    private void sort(int[] nums, int low, int high) {
        divide(nums, low, high);
    }

    private void divide(int[] nums, int low, int high) {

        if (low == high) {
            return;
        }

        int mid = (low + high) / 2;
        divide(nums, low, mid);
        divide(nums, mid + 1, high);

        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {

        int left = low;
        int right = mid + 1;
        List<Integer> temp = new ArrayList<>();
        while (left <= mid && right <= high) {

            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            }
            else {
                temp.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }

        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }
}
