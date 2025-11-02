package com.datastructures.v2.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CheapestFlights {

    private int solve(int[][] flights, int n, int src, int dst, int k) {

        List<List<Pair<Integer, Integer>>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            graph.get(flights[i][0]).add(new Pair<>(flights[i][1], flights[i][2]));
        }

        int[] dist = solve(graph, n, src, k);

        return (dist[dst] == Integer.MAX_VALUE) ? -1 : dist[dst];
    }

    private int[] solve(List<List<Pair<Integer, Integer>>> graph, int n, int src, int k) {

        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        Queue<Triplet<Integer, Integer, Integer>> queue = new ArrayDeque<>();
        dist[src] = 0;
        queue.offer(new Triplet<>(0, src, dist[src]));

        while (!queue.isEmpty()) {

            Triplet<Integer, Integer, Integer> vi = queue.poll();
            int s = vi.first();
            int v = vi.second();
            int d1 = vi.third();

            if (s > k) {
                break;
            }

            for (Pair<Integer, Integer> nvi : graph.get(v)) {
                int nv = nvi.first();
                int d2 = nvi.second();

                if (d1 + d2 < dist[nv]) {
                    dist[nv] = d1 + d2;
                    queue.offer(new Triplet<>(s + 1, nv, dist[nv]));
                }
            }
        }

        return dist;
    }
}
