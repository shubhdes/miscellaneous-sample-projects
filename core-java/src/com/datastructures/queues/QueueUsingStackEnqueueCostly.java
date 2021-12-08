package com.datastructures.queues;

import java.util.Stack;

public class QueueUsingStackEnqueueCostly {

	private final Stack<Integer> STACK1 = new Stack<>();

	private final Stack<Integer> STACK2 = new Stack<>();

	public void enqueue(Integer element) {
		while (!STACK1.isEmpty()) {
			STACK2.push(STACK1.pop());
		}
		STACK1.push(element);
		while (!STACK2.isEmpty()) {
			STACK1.push(STACK2.pop());
		}
	}

	public Integer dequeue() {
		return STACK1.pop();
	}

	@Override
	public String toString() {
		return "QueueUsingStackEnqueueCostly [STACK1=" + STACK1.toString() + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingStackEnqueueCostly queue = new QueueUsingStackEnqueueCostly();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		System.out.println(queue);
		queue.dequeue();
		System.out.println(queue);
		queue.enqueue(50);
		System.out.println(queue);
		queue.dequeue();
		System.out.println(queue);
	}

}
