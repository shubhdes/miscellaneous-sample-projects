package com.datastructures.v2.arrays;

import java.util.ArrayList;

public class CountInversion {

    private int mergesort(int[] nums, int low, int high) {

        int count = 0;
        if (low == high) {
            return count;
        }

        int mid = (low + high) / 2;
        count += mergesort(nums, low, mid);
        count += mergesort(nums, mid + 1, high);

        count += mergesort(nums, low, mid, high);

        return count;
    }

    private int mergesort(int[] nums, int low, int mid, int high) {

        int left = low;
        int right = mid + 1;

        int count = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        while (left <= mid && right <= high) {

            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            }
            else {
                temp.add(nums[right]);
                right++;
                count = count + (mid - left) + 1;
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

        return count;
    }
}
