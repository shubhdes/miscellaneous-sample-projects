package com.datastructures.arrays;

import java.util.ArrayList;

public class CountReverseInversions {

    private int solve(int[] nums, int n) {
        return mergesort(nums, 0, n - 1);
    }

    private int mergesort(int[] nums, int low, int high) {

        int count = 0;

        if(low == high) {
            return count;
        }

        int mid = (low + high) / 2;

        count += mergesort(nums, low, mid);
        count += mergesort(nums, mid + 1, high);
        count += countpairs(nums, low, mid, high);

        mergesort(nums, low, mid, high);

        return count;
    }

    private int countpairs(int[] nums, int low, int mid, int high) {

        int left = low;
        int right = mid + 1;
        int count = 0;
        while (left <= mid) {

            while (right <= high && nums[left] > 2 * nums[right]) {
                right++;
            }
            count = count + (right - (mid + 1));
            left++;
        }
        return count;
    }

    private void mergesort(int[] nums, int low, int mid, int high) {

        int left = low;
        int right = mid + 1;
        ArrayList<Integer> result = new ArrayList<>();
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                result.add(nums[left]);
                left++;
            } else {
                result.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
            result.add(nums[left]);
            left++;
        }

        while (right <= high) {
            result.add(nums[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            nums[i] = result.get(i - low);
        }
    }
}
