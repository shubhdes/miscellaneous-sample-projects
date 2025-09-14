package com.datastructures.arrays;

public class MissingAndRepeating {

    private int[] solve(int[] nums, int n) {

        long sumn = (n * (n + 1)) / 2;
        long sumsqn = (n * (n + 1) * (2 * n + 1)) / 6;

        long sumnums = 0;
        long sumsqnums = 0;
        for (int i = 0; i < n; i++) {
            sumnums = sumnums + nums[i];
            sumsqnums = sumsqnums + (nums[i] * nums[i]);
        }

        long repminusmiss = sumn - sumnums;
        long repplusmiss = (sumsqn - sumsqnums) / repminusmiss;

        int rep = (int) ((repminusmiss + repplusmiss) / 2);
        int miss = (int) (repplusmiss - rep);

        return new int[] {rep, miss};
    }
}
