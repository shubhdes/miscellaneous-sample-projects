package com.datastructures.custom;

public class CustomOrdinaryTree {

	public class Node {

		private Object data;

		private Node left;

		private Node right;

		public Node(Object data) {
			super();
			this.data = data;
		}

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

	}

	public CustomOrdinaryTree() {

	}

	public Node add(Object data) {
		CustomOrdinaryTree.Node node = this.new Node(data);
		return node;
	}
}
