package com.datastructures.graphs;

import java.util.ArrayList;

public class FlowerPlanting {

    private int[] solve(int[][] paths, int n) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < paths.length; i++) {
            graph.get(paths[i][0] - 1).add(paths[i][1] - 1);
            graph.get(paths[i][1] - 1).add(paths[i][0] - 1);
        }

        int[] gardens = new int[n];
        for (int i = 0; i < n; i++) {
            if (gardens[i] == 0) {
                solve(graph, n, gardens, i);
            }
        }

        return gardens;
    }

    private boolean solve(ArrayList<ArrayList<Integer>> graph, int n, int[] gardens, int garden) {

        for (int i = 1; i <= 4; i++) {
            if (isSafe(graph, n, gardens, garden, i)) {
                boolean allColored = true;
                gardens[garden] = i;
                for (Integer ngarden : graph.get(garden)) {
                    if (gardens[ngarden] == 0 && !solve(graph, n, gardens, ngarden)) {
                        allColored = false;
                        break;
                    }
                }
                if (allColored) {
                    return true;
                }
                gardens[garden] = 0;
            }
        }
        return false;
    }

    private boolean isSafe(ArrayList<ArrayList<Integer>> graph, int n, int[] gardens, int garden, int color) {

        for (Integer ngarden : graph.get(garden)) {
            if (gardens[ngarden] == color) {
                return false;
            }
        }
        return true;
    }
}
