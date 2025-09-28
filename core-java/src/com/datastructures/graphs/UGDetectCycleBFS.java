package com.datastructures.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

public class UGDetectCycleBFS {

    private boolean solve(ArrayList<ArrayList<Integer>> graph, int n) {

        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);

        ArrayDeque<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        queue.offer(new Pair<>(0, -1));

        while (!queue.isEmpty()) {

            Pair<Integer, Integer> element = queue.poll();
            int v = element.first();
            int p = element.second();

            for (Integer nv : graph.get(v)) {
                if (!visited.contains(v)) {
                    visited.add(v);
                    queue.offer(new Pair<>(nv, v));
                }
                else if (nv != p) {
                    return true;
                }
            }
        }
        return false;
    }
}
