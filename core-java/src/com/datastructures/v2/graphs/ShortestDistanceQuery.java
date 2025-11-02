package com.datastructures.v2.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestDistanceQuery {

    private int[] solve(int[][] queries, int n) {

        List<List<Pair<Integer, Integer>>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            if (i != n - 1) {
                graph.get(i).add(new Pair<>(i + 1, 1));
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            graph.get(queries[i][0]).add(new Pair<>(queries[i][1], 1));
            int[] dist = solve(graph, n, 0);
            result[i] = dist[n - 1];
        }

        return result;
    }

    private int[] solve(List<List<Pair<Integer, Integer>>> graph, int n, int src) {

        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        Queue<Pair<Integer, Integer>> queue = new PriorityQueue<>((p1, p2) -> p1.second() - p2.second());
        dist[src] = 0;
        queue.offer(new Pair<>(src, dist[src]));

        while (!queue.isEmpty()) {

            Pair<Integer, Integer> vi = queue.poll();
            int v = vi.first();
            int d1 = vi.second();

            for (Pair<Integer, Integer> nvi : graph.get(v)) {
                int nv = nvi.first();
                int d2 = nvi.second();

                if (d1 + d2 < dist[nv]) {
                    dist[nv] = d1 + d2;
                    queue.offer(new Pair<>(nv, dist[nv]));
                }
            }
        }

        return dist;
    }
}
