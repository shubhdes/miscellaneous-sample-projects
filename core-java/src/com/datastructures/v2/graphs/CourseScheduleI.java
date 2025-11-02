package com.datastructures.v2.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleI {

    private boolean solve(int[][] prerequisites, int n) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        List<Integer> result = solve(graph, n);
        return n == result.size();
    }

    private List<Integer> solve(List<List<Integer>> graph, int n) {

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

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            result.add(v);
            for (Integer nv: graph.get(v)) {
                indegree[nv]--;
                if (indegree[nv] == 0) {
                    queue.offer(nv);
                }
            }
        }

        return result;
    }
}
