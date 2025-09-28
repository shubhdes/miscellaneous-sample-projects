package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LeastNeighborsCount {

    private int solve(int[][] edges, int n, int distanceThreshold) {

        List<List<Pair<Integer, Integer>>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new Pair<>(edges[i][1], edges[i][2]));
        }

        int mini = n + 1;
        int mincount = n + 1;
        for (int i = 0; i < n; i++) {
            int[] dist = solve(graph, n, i);
            int count = countReachableCities(dist, n, distanceThreshold);
            if (count <= mincount) {
                mincount = count;
                mini = i;
            }
        }
        return mini;
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
