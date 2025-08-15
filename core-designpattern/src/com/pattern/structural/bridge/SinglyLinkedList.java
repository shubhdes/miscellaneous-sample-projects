package com.pattern.structural.bridge;

public class SinglyLinkedList<T> implements LinkedList<T> {

	private class Node {
		T data;
		Node next;

		private Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node top;
	private Node last;
	private int size;

	@Override
	public void addFirst(T t) {
		Node temp = new Node(t, null);
		if (size == 0) {
			top = temp;
			last = temp;
		} else {
			temp.next = top;
			top = temp;
		}
		size++;
	}

	@Override
	public T removeFirst() {
		if (size == 0) {
			return null;
		}
		Node temp = top;
		if (size == 1) {
			top = null;
			last = null;
		} else {
			top = temp.next;
		}
		size--;
		return temp.data;
	}

	@Override
	public void addLast(T t) {
		Node temp = new Node(t, null);
		if (size == 0) {
			top = temp;
			last = temp;
		} else {
			last.next = temp;
			last = temp;
		}
		size++;
	}

	@Override
	public T removeLast(T t) {
		if (size == 0) {
			return null;
		}
		Node temp = last;
		if (size == 1) {
			top = null;
			last = null;
		} else {
			Node i = top;
			while (i.next != last) {
				i = i.next;
			}
			last = i;
			last.next = null;
		}
		size--;
		return temp.data;
	}

}
