package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

	private void traverse(List<List<Integer>> adjacencyList, boolean[] visited, int currentVertex) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(currentVertex);
		visited[currentVertex] = true;
		while (!queue.isEmpty()) {
			int vertex = queue.poll();
			System.out.println(vertex);
			List<Integer> nextVertices = adjacencyList.get(vertex);
			for (Integer nextVertex : nextVertices) {
				if (!visited[nextVertex]) {
					queue.offer(nextVertex);
					visited[nextVertex] = true;
				}
			}
		}
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
		boolean[] visited = new boolean[adjacencyList.size()];
		BreadthFirstSearch bfs = new BreadthFirstSearch();
		bfs.traverse(adjacencyList, visited, 3);
	}
}
