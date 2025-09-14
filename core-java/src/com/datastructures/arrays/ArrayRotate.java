package com.datastructures.arrays;

public class ArrayRotate {

    private void solve(int[] arr, int n, int k) {
        leftrotate(arr, n, k);
    }

    private void leftrotate(int[] arr, int n, int k) {
        k = k % n;
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
        reverse(arr, 0, n - 1);
    }

    private void rightrotate(int[] arr, int n, int k) {
        k = k % n;
        reverse(arr, n - k, n - 1);
        reverse(arr, 0, n - k - 1);
        reverse(arr, 0, n - 1);
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
