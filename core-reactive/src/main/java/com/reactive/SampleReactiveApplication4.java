package com.reactive;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class SampleReactiveApplication4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

//		ConnectableObservable<Long> source = Observable.interval(1, TimeUnit.SECONDS).publish();
//		source.connect();

//		ConnectableObservable<Long> source = Observable.interval(1, TimeUnit.SECONDS).replay(3);
//		source.connect();

		Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS).cache();

		source.subscribe((event) -> System.out.println("observer 0 - " + event), Throwable::printStackTrace,
				() -> System.out.println("All events consumed!!"));

		Thread.sleep(5000);

		source.subscribe((event) -> System.out.println("observer 1 - " + event), Throwable::printStackTrace,
				() -> System.out.println("All events consumed!!"));

		Thread.sleep(10000);
	}
}
