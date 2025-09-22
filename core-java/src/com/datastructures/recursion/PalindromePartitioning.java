package com.datastructures.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    private void solve(String text, int n, int index, List<String> tempresult, List<List<String>> result) {

        if (n == index) {
            result.add(new ArrayList<>(tempresult));
            return;
        }

        for (int i = index; i < n; i++) {
            if (isPalindrome(text, index, i)) {
                tempresult.add(text.substring(index, i + 1));
                solve(text, n, i + 1, tempresult, result);
                tempresult.remove(tempresult.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String text, int i, int j) {

        while (i <= j) {
            if (text.charAt(i) != text.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
