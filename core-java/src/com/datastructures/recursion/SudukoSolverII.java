package com.datastructures.recursion;

public class SudukoSolverII {

    private boolean solve(char[][] board, int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (char dig = '1'; dig <= '9'; dig++) {
                    if (isValid(board, n, i, j, dig)) {
                        board[i][j] = dig;
                        if (solve(board, n)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
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
