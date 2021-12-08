package com.datastructures.custom;

public class CustomBinarySearchTree<T extends Comparable<T>> {

	private CustomBinarySearchTree<T>.Node root;

	public class Node {

		private T data;

		private Node left;

		private Node right;

		public Node(T data) {
			super();
			this.data = data;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
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

		@Override
		public String toString() {
			return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
		}

	}

	public CustomBinarySearchTree() {

	}

	public CustomBinarySearchTree<T>.Node getRoot() {
		return root;
	}

	public void setRoot(CustomBinarySearchTree<T>.Node root) {
		this.root = root;
	}

	public CustomBinarySearchTree<T>.Node add(T data) {
		CustomBinarySearchTree<T>.Node node = this.new Node(data);
		if (null == root) {
			root = node;
		} else {
			CustomBinarySearchTree<T>.Node currentNode = root;
			while (null != currentNode) {
				if (currentNode.getData().compareTo(data) >= 1) {
					if (null != currentNode.getLeft()) {
						currentNode = currentNode.getLeft();
						continue;
					}
					currentNode.setLeft(node);
					break;
				} else {
					if (null != currentNode.getRight()) {
						currentNode = currentNode.getRight();
						continue;
					}
					currentNode.setRight(node);
					break;
				}
			}
		}
		return node;
	}

}
