package com.pattern.structural.bridge;

public class Queue<T> implements FifoCollection<T> {

	private LinkedList<T> list;

	public Queue(LinkedList<T> list) {
		this.list = list;
	}

	@Override
	public void offer(T t) {
		list.addLast(t);
	}

	@Override
	public T poll() {
		return list.removeFirst();
	}
}
