package com.datastructures.graphs;

import java.util.ArrayList;

public class BipartiteGraphDFS {

    private boolean solve(ArrayList<ArrayList<Integer>> graph, int n, int v, int color, int[] colors) {

        colors[v] = color;

        for (Integer nv : graph.get(v)) {
            if (colors[nv] == 0) {
                if (!solve(graph, n, nv, 3 - colors[v], colors)) {
                    return false;
                }
            }
            else if (colors[nv] == colors[v]) {
                return false;
            }
        }
        return true;
    }
}
