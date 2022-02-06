package com.reactive;

import io.reactivex.rxjava3.core.Observable;

public class SampleReactiveApplication3 {

	public static void main(String[] args) throws InterruptedException {

//	    Observable
//	    	.merge(Observable.interval(1, TimeUnit.SECONDS).map(event -> "source 0 - " + event),
//	    			Observable.interval(1, TimeUnit.SECONDS).map(event -> "source 1 - " + event))
//	    	.subscribe(System.out::println, Throwable::printStackTrace,
//	    			() -> System.out.println("All events consumed!!"));		

//	    Observable
//	    	.concat(Observable.interval(1, TimeUnit.SECONDS).map(event -> "source 0 - " + event),
//	    			Observable.interval(1, TimeUnit.SECONDS).map(event -> "source 1 - " + event))
//	    	.subscribe(System.out::println, Throwable::printStackTrace,
//	    			() -> System.out.println("All events consumed!!"));

//		final String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
//		Observable.fromArray(days).flatMap(day -> Observable.fromArray(day.split(""))).subscribe(System.out::println,
//				Throwable::printStackTrace, () -> System.out.println("Week completed!!"));

//		final String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
//		Observable.fromArray(days).concatMap(day -> Observable.fromArray(day.split(""))).subscribe(System.out::println,
//				Throwable::printStackTrace, () -> System.out.println("Week completed!!"));

//		Observable
//				.amb(Arrays.asList(Observable.interval(1, TimeUnit.SECONDS).map(event -> "source 0 - " + event),
//						Observable.interval(500, TimeUnit.MILLISECONDS).map(event -> "source 1 - " + event)))
//				.subscribe(System.out::println, Throwable::printStackTrace,
//						() -> System.out.println("All events consumed!!"));

//		Observable.zip(Observable.interval(1, TimeUnit.SECONDS).map(event -> "source 0 - " + event),
//				Observable.interval(500, TimeUnit.MILLISECONDS).map(event -> "source 1 - " + event), String::concat)
//				.subscribe(System.out::println, Throwable::printStackTrace,
//						() -> System.out.println("All events consumed!!"));

//		Observable.combineLatest(Observable.interval(1, TimeUnit.SECONDS).map(event -> "source 0 - " + event),
//				Observable.interval(500, TimeUnit.MILLISECONDS).map(event -> "source 1 - " + event), String::concat)
//				.subscribe(System.out::println, Throwable::printStackTrace,
//						() -> System.out.println("All events consumed!!"));
//		

//		Observable.just(new Employee(1001, "john", 4.5f), new Employee(1002, "jack", 3.3f),
//				new Employee(1003, "alice", 4.1f), new Employee(1004, "bob", 4.5f), new Employee(1005, "smith", 4.4f),
//				new Employee(1006, "joy", 3.3f), new Employee(1007, "joe", 4.5f), new Employee(1008, "jose", 4.5f),
//				new Employee(1009, "tom", 4.4f), new Employee(1010, "harry", 3.3f))
//				// .groupBy(employee -> employee.getRating(), employee -> employee.getName())
//				.collect(Collectors.groupingBy(Employee::getRating, Collectors.toList()))
//				.subscribe(System.out::println, Throwable::printStackTrace);

		Observable<Long> source = Observable.create(emitter -> {
			for (long i = 1; i <= 1000; i++) {
				emitter.onNext(i);
			}
			emitter.onComplete();
		});

//		Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);

		source.subscribe((data) -> System.out.println("Observer-0:" + data), Throwable::printStackTrace,
				() -> System.out.println("All events consumed!!"));

		source.subscribe((data) -> System.out.println("Observer-1:" + data), Throwable::printStackTrace,
				() -> System.out.println("All events consumed!!"));

//		Thread.sleep(120000);
	}
}
