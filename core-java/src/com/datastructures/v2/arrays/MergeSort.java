package com.datastructures.v2.arrays;

import java.util.ArrayList;

public class MergeSort {

    private void mergesort(int[] nums, int low, int high) {

        if (low == high) {
            return;
        }

        int mid = (low + high) / 2;
        mergesort(nums, low, mid);
        mergesort(nums, mid + 1, high);

        mergesort(nums, low, mid, high);
    }

    private void mergesort(int[] nums, int low, int mid, int high) {

        int left = low;
        int right = mid + 1;
        ArrayList<Integer> temp = new ArrayList<>();
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
