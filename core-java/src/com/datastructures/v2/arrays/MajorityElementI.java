package com.datastructures.v2.arrays;

public class MajorityElementI {

    private int solve(int[] nums, int n) {

        int count = 0;
        int element = 0;
        for (int i = 0; i < n; i++) {

            if (count == 0) {
                element = nums[i];
                count = 1;
            }
            else if (element == nums[i]) {
                count++;
            }
            else {
                count--;
            }
        }

        return element;
    }
}
