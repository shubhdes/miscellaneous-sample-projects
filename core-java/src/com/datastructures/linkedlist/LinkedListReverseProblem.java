package com.datastructures.linkedlist;

import com.datastructures.custom.CustomLinkedList;

public class LinkedListReverseProblem {

	private static final CustomLinkedList LINKED_LIST = new CustomLinkedList();

	private static final CustomLinkedList.Node HEAD;

	static {
		HEAD = LINKED_LIST.add(10);
		LINKED_LIST.add(20);
		LINKED_LIST.add(30);
		LINKED_LIST.add(40);
		LINKED_LIST.add(50);
		LINKED_LIST.add(60);
		LINKED_LIST.add(70);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverse(HEAD);
		System.out.println(LINKED_LIST);
	}

	public static void reverse(CustomLinkedList.Node head) {
		CustomLinkedList.Node previous = null;
		CustomLinkedList.Node next = null;
		CustomLinkedList.Node current = head;
		while (null != current) {
			next = current.getNext();
			current.setNext(previous);
			previous = current;
			current = next;
		}
		head = previous;
		LINKED_LIST.setHead(head);
	}
}
