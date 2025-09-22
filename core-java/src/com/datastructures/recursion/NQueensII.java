package com.datastructures.recursion;

public class NQueensII {

    private void solve(char[][] board, int n, int col,
                       int[] left, int[] lowerdiag, int[] upperdiag, int[] count) {

        if (col == n) {
            count[0]++;
            return;
        }

        for (int row = 0; row < n; row++) {

            if (left[row] == 0 && lowerdiag[n - 1 + col - row] == 0 && upperdiag[row + col] == 0) {

                left[row] = 1;
                lowerdiag[n - 1 + col - row] = 1;
                upperdiag[row + col] = 1;
                board[row][col] = 'Q';

                solve(board, n, col + 1, left, lowerdiag, upperdiag, count);

                left[row] = 0;
                lowerdiag[n - 1 + col - row] = 0;
                upperdiag[row + col] = 0;
                board[row][col] = '.';
            }
        }
    }
}