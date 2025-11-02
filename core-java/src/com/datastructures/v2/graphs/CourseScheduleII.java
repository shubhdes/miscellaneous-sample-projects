package com.datastructures.v2.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {

    private int[] solve(int[][] prerequisites, int n) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        return solve(graph, n);
    }

    private int[] solve(List<List<Integer>> graph, int n) {

        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (Integer v: graph.get(i)) {
                indegree[v]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int i = 0;
        int[] result = new int[n];
        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            result[i] = v;
            for (Integer nv: graph.get(v)) {
                indegree[nv]--;
                if (indegree[nv] == 0) {
                    queue.offer(nv);
                }
            }
            i++;
        }

        return (i == n) ? result : new int[] {};
    }
}
