package com.datastructures.graphs;

import java.util.PriorityQueue;

public class MinimumEffortPath {

    private int solve(int[][] heights, int n, int m) {

        int[][] efforts = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                efforts[i][j] = Integer.MAX_VALUE;
            }
        }
        efforts[0][0] = 0;

        PriorityQueue<Triplet<Integer, Integer, Integer>> queue =
                new PriorityQueue<>((p1, p2) -> p1.third() - p2.third());
        queue.offer(new Triplet<>(0,0,0));

        int[] drow = {-1, 1, 0, 0};
        int[] dcol = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            Triplet<Integer, Integer, Integer> element = queue.poll();
            int row = element.first();
            int col = element.second();
            int e = element.third();

            if (row == n - 1 && col == m - 1) {
                return e;
            }

            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow == -1 || ncol == -1 || nrow == n || ncol == m) {
                    continue;
                }

                int ne = Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]), e);
                if (ne < efforts[nrow][ncol]) {
                    efforts[nrow][ncol] = ne;
                    queue.offer(new Triplet<>(nrow, ncol, ne));
                }
            }
        }

        return -1;
    }
}
