package com.datastructures.arrays;

public class MergeTwoSortedArrays {

    private void solve(int[] nums1, int n, int[] nums2, int m) {

        int len = n + m;
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            while (right < len) {

                if (left < n && right >= n) {
                    swapWhenLeftGreaterThanRight(nums1, left, nums2, right - n);
                }
                else if (left >= n) {
                    swapWhenLeftGreaterThanRight(nums1, left - n, nums2, right - n);
                }
                else {
                    swapWhenLeftGreaterThanRight(nums1, left, nums2, right);
                }
                left++;
                right++;
            }

            if (gap == 1) {
                break;
            }
            gap = (gap / 2) + (gap % 2);
        }
    }

    private void swapWhenLeftGreaterThanRight(int[] nums1, int left, int nums2[], int right) {
        if (nums1[left] > nums2[right]) {
            int t = nums1[left];
            nums1[left] = nums2[right];
            nums2[right] = t;
        }
    }
}
