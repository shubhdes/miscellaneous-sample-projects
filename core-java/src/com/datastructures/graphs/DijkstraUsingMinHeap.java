package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import javafx.util.Pair;

public class DijkstraUsingMinHeap {

	public void dijkstra(List<List<List<Integer>>> adjacencyList, int source) {

		int[] distance = new int[adjacencyList.size()];
		for (int i = 0; i < distance.length; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[source] = 0;
		PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(
				(pair1, pair2) -> pair1.getValue() - pair2.getValue());
		queue.offer(new Pair<>(source, 0));
		while (!queue.isEmpty()) {
			Pair<Integer, Integer> vertexDistPair = queue.poll();
			int vertex = vertexDistPair.getKey();
			int dist = vertexDistPair.getValue();
			List<List<Integer>> nextVertices = adjacencyList.get(vertex);
			for (List<Integer> nextVertex : nextVertices) {
				if (dist + nextVertex.get(1) < distance[nextVertex.get(0)]) {
					distance[nextVertex.get(0)] = dist + nextVertex.get(1);
					queue.offer(new Pair<>(nextVertex.get(0), dist + nextVertex.get(1)));
				}
			}
		}
		for (int i = 0; i < distance.length; i++) {
			System.out.println(distance[i]);
		}
	}

	public static void main(String[] args) {
		List<List<List<Integer>>> adjacencyList = new ArrayList<List<List<Integer>>>();
		adjacencyList.add(Arrays.asList(Arrays.asList(1, 4), Arrays.asList(2, 4)));
		adjacencyList.add(Arrays.asList(Arrays.asList(0, 4), Arrays.asList(2, 2)));
		adjacencyList.add(Arrays.asList(Arrays.asList(0, 4), Arrays.asList(1, 2), Arrays.asList(3, 3),
				Arrays.asList(4, 1), Arrays.asList(5, 6)));
		adjacencyList.add(Arrays.asList(Arrays.asList(2, 3), Arrays.asList(5, 2)));
		adjacencyList.add(Arrays.asList(Arrays.asList(2, 1), Arrays.asList(5, 3)));
		adjacencyList.add(Arrays.asList(Arrays.asList(2, 6), Arrays.asList(3, 2), Arrays.asList(4, 3)));
		DijkstraUsingMinHeap dijkstraUsingMinHeap = new DijkstraUsingMinHeap();
		dijkstraUsingMinHeap.dijkstra(adjacencyList, 0);
	}
}
