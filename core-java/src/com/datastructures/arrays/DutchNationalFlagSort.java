package com.datastructures.arrays;

import java.util.Arrays;

public class DutchNationalFlagSort {

    private void sort(int[] arr, int n) {
        int low = 0;
        int mid = 0;
        int high = n - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, mid, low);
                low++;
                mid++;
            }
            else if (arr[mid] == 1) {
                mid++;
            }
            else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0};

        DutchNationalFlagSort algo = new DutchNationalFlagSort();
        algo.sort(arr, arr.length);

        System.out.println(Arrays.toString(arr));
    }
}
