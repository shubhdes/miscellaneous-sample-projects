package com.datastructures.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class CourseScheduleI {

    private boolean solve(int[][] prerequisites, int n) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] result = solve(graph, n);

        return n == result.length;
    }

    private int[] solve(ArrayList<ArrayList<Integer>> graph, int n) {

        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (Integer j : graph.get(i)) {
                indegree[j]++;
            }
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
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
            for (Integer nv : graph.get(v)) {
                indegree[nv]--;
                if (indegree[nv] == 0) {
                    queue.offer(nv);
                }
            }
            i++;
        }

        return result;
    }
}
