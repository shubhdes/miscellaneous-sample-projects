package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortingUsingBreadthFirstSearch {

	private void topologicalSort(List<List<Integer>> adjacencyList) {

		int[] inDegree = new int[adjacencyList.size()];
		for (int currentVertex = 0; currentVertex < inDegree.length; currentVertex++) {
			List<Integer> nextVertices = adjacencyList.get(currentVertex);
			for (Integer nextVertex : nextVertices) {
				inDegree[nextVertex]++;
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int currentVertex = 0; currentVertex < inDegree.length; currentVertex++) {
			if (inDegree[currentVertex] == 0) {
				queue.offer(currentVertex);
			}
		}

		while (!queue.isEmpty()) {
			int currentVertex = queue.poll();
			System.out.println(currentVertex);
			List<Integer> nextVertices = adjacencyList.get(currentVertex);
			for (Integer nextVertex : nextVertices) {
				inDegree[nextVertex]--;
				if (inDegree[nextVertex] == 0) {
					queue.offer(nextVertex);
				}
			}
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> adjacencyList = new ArrayList<List<Integer>>();
		adjacencyList.add(Arrays.asList());
		adjacencyList.add(Arrays.asList());
		adjacencyList.add(Arrays.asList(3));
		adjacencyList.add(Arrays.asList(1));
		adjacencyList.add(Arrays.asList(0, 1));
		adjacencyList.add(Arrays.asList(0, 2));
		TopologicalSortingUsingBreadthFirstSearch bfs = new TopologicalSortingUsingBreadthFirstSearch();
		bfs.topologicalSort(adjacencyList);
	}
}
