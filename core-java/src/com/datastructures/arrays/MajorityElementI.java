package com.datastructures.arrays;

public class MajorityElementI {

    private int solve(int[] arr, int n) {

        int count = 0;
        int element = -1;

        for (int i = 0; i < n; i++) {
            if (count == 0) {
                element = arr[i];
                count = 1;
            }
            else if (arr[i] == element) {
                count++;
            }
            else {
                count--;
            }
        }

        return element;
    }
}
