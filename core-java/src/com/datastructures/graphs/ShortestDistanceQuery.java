package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

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
        dist[src] = 0;

        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>((p1, p2) -> p1.second() - p2.second());
        queue.offer(new Pair<>(src, dist[src]));

        while (!queue.isEmpty()) {

            Pair<Integer, Integer> element = queue.poll();
            int v = element.first();
            int currdist = element.second();

            for(Pair<Integer, Integer> nvinfo : graph.get(v)) {
                int nv = nvinfo.first();
                int reqdist = nvinfo.second();

                if (currdist + reqdist < dist[nv]) {
                    dist[nv] = currdist + reqdist;
                    queue.offer(new Pair<>(nv, dist[nv]));
                }
            }
        }

        return dist;
    }
}
