package com.datastructures.recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueensI {

    private void solve(char[][] board, int n, int col,
                       int[] left, int[] lowerdiag, int[] upperdiag, List<List<String>> result) {

        if (col == n) {
            copy(board, n, result);
            return;
        }

        for (int row = 0; row < n; row++) {

            if (left[row] == 0 && lowerdiag[n - 1 + col - row] == 0 && upperdiag[row + col] == 0) {

                left[row] = 1;
                lowerdiag[n - 1 + col - row] = 1;
                upperdiag[row + col] = 1;
                board[row][col] = 'Q';

                solve(board, n, col + 1, left, lowerdiag, upperdiag, result);

                left[row] = 0;
                lowerdiag[n - 1 + col - row] = 0;
                upperdiag[row + col] = 0;
                board[row][col] = '.';
            }
        }
    }

    private void copy(char[][] board, int n, List<List<String>> result) {
        List<String> tempresult = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tempresult.add(new String(board[i]));
        }
        result.add(tempresult);
    }

}