package com.datastructures.arrays;

public class MoveZerosSort {

    private void solve(int[] arr, int n) {
        int i = 0;
        while (i < n) {
            if (arr[i] == 0) {
                break;
            }
            i++;
        }

        int j = i + 1;
        while (j < n) {
            if (arr[j] != 0) {
                swap(arr, i, j);
                i++;
            }
            j++;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
