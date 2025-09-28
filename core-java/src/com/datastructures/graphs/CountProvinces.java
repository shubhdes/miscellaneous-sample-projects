package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class CountProvinces {

    private int solve(int[][] isConnected, int n) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
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

        int count = 0;
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                count++;
                solve(graph, i, visited);
            }
        }

        return count;
    }

    private void solve(ArrayList<ArrayList<Integer>> graph, int v, HashSet<Integer> visited) {

        visited.add(v);

        for (Integer nv : graph.get(v)) {
            if (!visited.contains(nv)) {
                solve(graph, nv, visited);
            }
        }
    }
}
