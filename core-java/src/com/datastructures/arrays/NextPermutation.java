package com.datastructures.arrays;

public class NextPermutation {

    private int[] solve(int[] arr, int n) {

        int bp = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                bp = i;
                break;
            }
        }

        if (bp == -1) {
            reverse(arr, 0, n - 1);
            return arr;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > arr[bp]) {
                swap(arr, i, bp);
                break;
            }
        }

        reverse(arr, bp + 1, n - 1);
        return arr;
    }

    private void reverse(int[] arr, int start, int end) {

        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
