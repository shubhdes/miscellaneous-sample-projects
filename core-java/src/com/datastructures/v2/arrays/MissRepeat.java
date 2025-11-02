package com.datastructures.v2.arrays;

public class MissRepeat {

    private int[] solve(int[] nums, int n) {

        long sumn = ((long) n * (n + 1)) / 2;
        long sumsqn = ((long) n * (n + 1) * (2 * n + 1)) / 2;

        long sumnums = 0;
        long sumsqnums = 0;
        for (int i = 0; i < n; i++) {
            sumnums += nums[i];
            sumsqnums = ((long) nums[i] * nums[i]);
        }

        long repminusmiss = sumn - sumnums;
        long repplusmiss = (sumsqn - sumsqnums) / repminusmiss;

        int rep = (int) ((repminusmiss + repplusmiss) / 2);
        int miss = (int) (repplusmiss - rep);

        return new int[] {rep, miss};
    }
}
