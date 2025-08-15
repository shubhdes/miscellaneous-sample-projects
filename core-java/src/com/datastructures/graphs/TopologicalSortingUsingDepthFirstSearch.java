package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSortingUsingDepthFirstSearch {

	private void dfs(int currentVertex, List<List<Integer>> adjacencyList, int[] visitedVertices,
			Stack<Integer> linearOrderStack) {
		if (visitedVertices[currentVertex] == 1) {
			return;
		}
		visitedVertices[currentVertex] = 1;
		List<Integer> nextVertices = adjacencyList.get(currentVertex);
		for (Integer nextVertex : nextVertices) {
			dfs(nextVertex, adjacencyList, visitedVertices, linearOrderStack);
		}
		linearOrderStack.push(currentVertex);
	}

	private void topologicalSort(List<List<Integer>> adjacencyList) {
		int[] visitedVertices = new int[adjacencyList.size()];
		Stack<Integer> linearOrderStack = new Stack<>();
		for (int currentVertex = 0; currentVertex < adjacencyList.size(); currentVertex++) {
			dfs(currentVertex, adjacencyList, visitedVertices, linearOrderStack);
		}
		while (!linearOrderStack.isEmpty()) {
			System.out.println(linearOrderStack.pop());
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
		TopologicalSortingUsingDepthFirstSearch dfs = new TopologicalSortingUsingDepthFirstSearch();
		dfs.topologicalSort(adjacencyList);
	}
}
