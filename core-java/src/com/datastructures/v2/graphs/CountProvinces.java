package com.datastructures.v2.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CountProvinces {

    private int solve(int[][] isConnected, int n) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }

        HashSet<Integer> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                count++;
                solve(graph, i, visited);
            }
        }

        return count;
    }

    private void solve(List<List<Integer>> graph, int v, HashSet<Integer> visited) {

        visited.add(v);

        for (Integer nv : graph.get(v)) {
            if (!visited.contains(nv)) {
                solve(graph, nv, visited);
            }
        }
    }
}
