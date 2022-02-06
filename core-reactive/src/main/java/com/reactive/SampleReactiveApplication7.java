package com.reactive;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class SampleReactiveApplication7 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		final String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

//		Observable.fromArray(days).flatMap(day -> Observable.fromArray(day.split(""))).subscribe(System.out::println,
//				Throwable::printStackTrace, () -> System.out.println("Week completed!!"));

		Observable.fromArray(days).switchMap(day -> Observable.fromArray(day.split("")).delay(2, TimeUnit.SECONDS))
				.subscribe(System.out::println, Throwable::printStackTrace,
						() -> System.out.println("Week completed!!"));

		Thread.sleep(2000000);
	}

}
