package com.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

    private List<Integer> solve(int[] arr, int n) {

        int count1 = 0;
        int element1 = -1;
        int count2 = 0;
        int element2 = -1;

        for (int i = 0; i < n; i++) {
            if (count1 == 0 && arr[i] != element2) {
                element1 = arr[i];
                count1 = 1;
            }
            else if (count2 == 0 && arr[i] != element1) {
                element2 = arr[i];
                count2 = 1;
            }
            else if (arr[i] == element1) {
                count1++;
            }
            else if (arr[i] == element2) {
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }

        return verify(arr, n, element1, element2);
    }

    private List<Integer> verify(int[] arr, int n, int element1, int element2) {

        List<Integer> result = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < n; i++) {

            if (arr[i] == element1) {
                count1++;
            }
            else if (arr[i] == element2) {
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
