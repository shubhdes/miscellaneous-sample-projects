package com.datastructures.trees;

import com.datastructures.custom.CustomOrdinaryTree;

public class InorderDepthFirstSearchUsingRecursion {

	private static final CustomOrdinaryTree TREE = new CustomOrdinaryTree();

	private static final CustomOrdinaryTree.Node ROOT;

	static {
		CustomOrdinaryTree.Node node9 = TREE.add(9);
		CustomOrdinaryTree.Node node4 = TREE.add(4);
		CustomOrdinaryTree.Node node6 = TREE.add(6);
		CustomOrdinaryTree.Node node1 = TREE.add(1);
		CustomOrdinaryTree.Node node20 = TREE.add(20);
		CustomOrdinaryTree.Node node15 = TREE.add(15);
		CustomOrdinaryTree.Node node170 = TREE.add(170);

		node9.setLeft(node4);
		node9.setRight(node20);
		node4.setLeft(node1);
		node4.setRight(node6);
		node20.setLeft(node15);
		node20.setRight(node170);

		ROOT = node9;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		traverse(ROOT);
	}

	public static void traverse(CustomOrdinaryTree.Node node) {
		if (null != node.getLeft()) {
			traverse(node.getLeft());
		}
		System.out.println(node.getData());
		if (null != node.getRight()) {
			traverse(node.getRight());
		}
	}
}
