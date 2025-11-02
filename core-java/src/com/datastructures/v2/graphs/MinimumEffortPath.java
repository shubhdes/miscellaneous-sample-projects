package com.datastructures.v2.graphs;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumEffortPath {

    private int solve(int[][] heights, int n, int m) {

        int[][] efforts = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                efforts[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<Triplet<Integer, Integer, Integer>> queue = new PriorityQueue<>((t1, t2) -> t1.third() - t2.third());
        efforts[0][0] = 0;
        queue.offer(new Triplet<>(0,0, efforts[0][0]));
        int[] drow = {-1, 1, 0, 0};
        int[] dcol = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            Triplet<Integer, Integer, Integer> vi = queue.poll();
            int row = vi.first();
            int col = vi.second();
            int e1 = vi.third();

            if (row == n - 1 && col == m - 1) {
                return e1;
            }

            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow == -1 || nrow == n || ncol == -1 || ncol == m) {
                    continue;
                }

                int e2 = Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]), e1);
                if (e2 < efforts[nrow][ncol]) {
                    efforts[nrow][ncol] = e2;
                    queue.offer(new Triplet<>(nrow, ncol, e2));
                }
            }
        }

        return  -1;
    }
}
