package com.datastructures.arrays;

public class MatrixZeros {

    private void solve(int[][] mat, int n, int m) {

        int col0 = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    if (j == 0) {
                        col0 = 0;
                    } else {
                        mat[0][j] = 0;
                    }
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] != 0 && (mat[i][0] == 0 || mat[0][j] == 0)) {
                    mat[i][j] = 0;
                }
            }
        }

        if (mat[0][0] == 0) {
            for (int i = 0; i < m; i++) {
                mat[0][i] = 0;
            }
        }

        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                mat[i][0] = 0;
            }
        }
    }
}
