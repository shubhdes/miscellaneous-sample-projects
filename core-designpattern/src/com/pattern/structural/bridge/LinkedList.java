package com.pattern.structural.bridge;

public interface LinkedList<T> {

	void addFirst(T t);

	T removeFirst();

	void addLast(T t);

	T removeLast(T t);
}
