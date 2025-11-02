package com.datastructures.v2.arrays;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

    private List<Integer> solve(int[] nums, int n) {

        int count1 = 0;
        int element1 = 0;
        int count2 = 0;
        int element2 = 0;
        for (int i = 0; i < n; i++) {

            if (count1 == 0 && element2 != nums[i]) {
                element1 = nums[i];
                count1 = 1;
            }
            else if (count2 == 0 && element1 != nums[i]) {
                element2 = nums[i];
                count2 = 1;
            }
            else if (element1 == nums[i]) {
                count1++;
            }
            else if (element2 == nums[i]) {
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }

        return verify(nums, n, element1, element2);
    }

    private List<Integer> verify(int[] nums, int n, int element1, int element2) {

        List<Integer> result = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < n; i++) {

            if (nums[i] == element1) {
                count1++;
            }
            else if (nums[i] == element2) {
                count2++;
            }
        }

        if (count1 > n/3) {
            result.add(element1);
        }

        if (count2 > n/3) {
            result.add(element2);
        }

        return result;
    }
}
