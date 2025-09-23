package com.datastructures.recursion;

import java.util.ArrayList;

public class PermutationSequence {

    private String solve(int n, int k) {

        k = k - 1;
        int fact = 1;
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            nums.add(i);
        }
        nums.add(n);

        String result = "";
        while (true) {
            result = result + nums.remove(k / fact);

            if (nums.isEmpty()) {
                break;
            }
            k = k % fact;
            fact = fact / nums.size();
        }

        return result;
    }
}
