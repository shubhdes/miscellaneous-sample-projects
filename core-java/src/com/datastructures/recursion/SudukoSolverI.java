package com.datastructures.recursion;

public class SudukoSolverI {

    private boolean solve(char[][] board, int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char dig = board[i][j];
                if (dig == '.') {
                    continue;
                }

                if (!isValid(board, n, i, j, dig)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int n, int row, int col, char dig) {

        for (int i = 0; i < n; i++) {

            if (i != col && board[row][i] == dig) {
                return false;
            }
            if (i != row && board[i][col] == dig) {
                return false;
            }
            int nrow = 3 * (row / 3) + i / 3;
            int ncol = 3 * (col / 3) + i % 3;
            if (row != nrow && col != ncol && board[nrow][ncol] == dig) {
                return false;
            }
        }
        return true;
    }
}
