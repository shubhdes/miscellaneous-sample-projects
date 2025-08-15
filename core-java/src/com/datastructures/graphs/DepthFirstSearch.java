package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepthFirstSearch {

	private void traverse(List<List<Integer>> adjacencyList, boolean[] visited, int currentVertex) {
		visited[currentVertex] = true;
		List<Integer> nextVertices = adjacencyList.get(currentVertex);
		for (Integer nextVertex : nextVertices) {
			if (!visited[nextVertex]) {
				traverse(adjacencyList, visited, nextVertex);
			}
		}
		System.out.println(currentVertex);
	}

	public static void main(String[] args) {
		List<List<Integer>> adjacencyList = new ArrayList<List<Integer>>();
		adjacencyList.add(Arrays.asList(1, 5));
		adjacencyList.add(Arrays.asList(0, 2, 3));
		adjacencyList.add(Arrays.asList(1));
		adjacencyList.add(Arrays.asList(1, 4));
		adjacencyList.add(Arrays.asList(3, 7));
		adjacencyList.add(Arrays.asList(0, 6, 8));
		adjacencyList.add(Arrays.asList(5, 7));
		adjacencyList.add(Arrays.asList(4, 6));
		adjacencyList.add(Arrays.asList(5));
		DepthFirstSearch dfs = new DepthFirstSearch();
		boolean[] visited = new boolean[adjacencyList.size()];
		dfs.traverse(adjacencyList, visited, 0);
	}
}
