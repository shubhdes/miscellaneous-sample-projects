package com.pattern.creational.objectpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;

public class ObjectPool<T extends Poolable> {

	private BlockingQueue<T> availablePool;

	public ObjectPool(Supplier<T> creator, int count) {
		this.availablePool = new LinkedBlockingQueue<>();
		for (int i = 0; i < count; i++) {
			availablePool.offer(creator.get());
		}
	}

	public T get() throws InterruptedException {
		return availablePool.take();
	}

	public void release(T poolable) throws InterruptedException {
		poolable.reset();
		availablePool.put(poolable);
	}
}
