package com.reactive;

import java.util.concurrent.CountDownLatch;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SampleReactiveApplication6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final Observable<Integer> source0 = Observable.range(1, 50).subscribeOn(Schedulers.computation());

		final CountDownLatch latch = new CountDownLatch(2);

		source0.subscribe((event) -> {
			System.out.println("Observer 0:" + event + " Thread:" + Thread.currentThread().getName());
		}, Throwable::printStackTrace, () -> latch.countDown());

		source0.subscribe((event) -> {
			System.out.println("Observer 1:" + event + " Thread:" + Thread.currentThread().getName());
		}, Throwable::printStackTrace, () -> latch.countDown());

		latch.await();
	}

}
