package com.datastructures.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class BipartiteGraphBFS {

    private boolean solve(ArrayList<ArrayList<Integer>> graph, int n, int src, int color, int[] colors) {

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);

        while (!queue.isEmpty()) {

            int v = queue.poll();
            for (Integer nv : graph.get(v)) {
                if (colors[nv] == 0) {
                    colors[nv] = 3 - colors[v];
                    queue.offer(nv);
                }
                else if (colors[nv] == colors[v]) {
                    return false;
                }
            }
        }
        return true;
    }
}
