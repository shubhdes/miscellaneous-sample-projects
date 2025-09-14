package com.datastructures.arrays;

import java.util.ArrayList;

public class PascalsTriangle {

    private int solve(int row, int col) {
        int p = row - 1;
        int q = col - 1;
        int result = 1;
        for (int i = 0; i < q; i++) {
            result = result * (p - i);
            result = result / (i + 1);
        }
        return result;
    }

    private ArrayList<Integer> solve(int row) {

        int p = row - 1;
        int t = 1;

        ArrayList<Integer> result = new ArrayList<>();
        result.add(t);

        for (int i = 1; i < p; i++) {
            t = t * (p - i);
            t = t / i;
            result.add(t);
        }
        return result;
    }

    private ArrayList<ArrayList<Integer>> solve1(int row) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 1; i < row; i++) {
            result.add(solve(row));
        }
        return result;
    }
}
