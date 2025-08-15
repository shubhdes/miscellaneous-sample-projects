package com.pattern.structural.bridge;

public interface FifoCollection<T> {

	void offer(T t);

	T poll();
}
