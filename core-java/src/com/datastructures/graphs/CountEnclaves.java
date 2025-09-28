package com.datastructures.graphs;

public class CountEnclaves {

    private int solve(int[][] grid, int n, int m) {

        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (visited[i][0] == 0) {
                solve(grid, n, m, i, 0, visited);
            }
            if (visited[i][m - 1] == 0) {
                solve(grid, n, m, i, m - 1, visited);
            }
        }

        for (int i = 0; i < m; i++) {
            if (visited[0][i] == 0) {
                solve(grid, n, m, 0, i, visited);
            }
            if (visited[n - 1][i] == 0) {
                solve(grid, n, m, n - 1, i, visited);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    private void solve(int[][] grid, int n, int m, int row, int col, int[][] visited) {

        if (row == -1 || col == -1 || row == n || col == m || grid[row][col] == 0 || visited[row][col] == 1) {
            return;
        }

        visited[row][col] = 1;

        solve(grid, n, m, row - 1, col, visited);
        solve(grid, n, m, row + 1, col, visited);
        solve(grid, n, m, row, col - 1, visited);
        solve(grid, n, m, row, col + 1, visited);
    }
}
