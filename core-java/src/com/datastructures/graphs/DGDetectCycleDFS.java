package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class DGDetectCycleDFS {

    private boolean solve(ArrayList<ArrayList<Integer>> graph, int n, HashSet<Integer> visited,
                          HashSet<Integer> pathvisited, int v) {

        visited.add(v);
        pathvisited.add(v);

        for (Integer nv : graph.get(v)) {
            if (!visited.contains(v)) {
                if (solve(graph, n, visited, pathvisited, nv)) {
                    return true;
                }
            }
            else if (pathvisited.contains(nv)) {
                return true;
            }
        }

        pathvisited.remove(v);
        return false;
    }
}
