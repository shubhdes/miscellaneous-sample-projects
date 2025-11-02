package com.datastructures.v2.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeastNeighborsCount {

    private int solve(int[][] edges, int n, int distanceThreshold) {

        List<List<Pair<Integer, Integer>>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new Pair<>(edges[i][1], edges[i][2]));
            graph.get(edges[i][1]).add(new Pair<>(edges[i][0], edges[i][2]));
        }

        int maxcity = -1;
        int mincount = n + 1;
        for (int i = 0; i < n; i++) {
            int[] dist = solve(graph, n, i);
            int count = countReachableCities(dist, n, distanceThreshold);
            if (count <= mincount) {
                mincount = count;
                maxcity = i;
            }
        }

        return maxcity;
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

    private int countReachableCities(int[] dist, int n, int distanceThreshold) {

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dist[i] <= distanceThreshold) {
                count++;
            }
        }
        return count - 1;
    }
}
