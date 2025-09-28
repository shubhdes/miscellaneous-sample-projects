package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class UGDetectCycleDFS {

    private boolean solve(ArrayList<ArrayList<Integer>> graph, int n, HashSet<Integer> visited, int v, int parent) {

        visited.add(v);

        for (Integer nv : graph.get(v)) {
            if (!visited.contains(v)) {
                if (solve(graph, n, visited, nv, v)) {
                    return true;
                }
            }
            else if (nv != parent) {
                return true;
            }
        }
        return false;
    }
}
