package com.datastructures.custom;

public class CustomLinkedList {

	private Node head;

	public class Node {

		private Object data;

		private Node next;

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

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

	public CustomLinkedList() {
		super();
	}

	public Node add(Object data) {
		Node node = null;
		if (null == head) {
			node = this.new Node(data);
			head = node;
		} else {
			Node tempNode = head;
			while (null != tempNode.getNext()) {
				tempNode = tempNode.getNext();
			}
			node = new Node(data);
			tempNode.setNext(node);
		}
		return node;
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		Node node = head;
		while (null != node) {
			buffer.append(node.getData() + " > ");
			node = node.getNext();
		}
		return buffer.toString();
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

}
