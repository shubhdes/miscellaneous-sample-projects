package com.datastructures.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class CheapestFlights {

    private int solve(int[][] flights, int n, int src, int dst, int k) {

        ArrayList<ArrayList<Pair<Integer, Integer>>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            graph.get(flights[i][0]).add(new Pair<>(flights[i][1], flights[i][2]));
        }

        int[] dist = solve(graph, n, src, k);

        return (dist[dst] == Integer.MAX_VALUE) ? -1 : dist[dst];
    }

    private int[] solve(ArrayList<ArrayList<Pair<Integer, Integer>>> graph, int n, int src, int k) {

        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        ArrayDeque<Triplet<Integer, Integer, Integer>> queue = new ArrayDeque<>();
        queue.offer(new Triplet<>(0, src, dist[src]));

        while (!queue.isEmpty()) {

            Triplet<Integer, Integer, Integer> element = queue.poll();
            int s = element.first();
            int v = element.second();
            int currdist = element.third();

            if (s > k) {
                continue;
            }

            for(Pair<Integer, Integer> nvinfo : graph.get(v)) {
                int nv = nvinfo.first();
                int reqdist = nvinfo.second();

                if (currdist + reqdist < dist[nv]) {
                    dist[nv] = currdist + reqdist;
                    queue.offer(new Triplet<>(s + 1, nv, dist[nv]));
                }
            }
        }

        return dist;
    }
}
