package com.reactive;

import java.util.stream.Stream;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class SampleReactiveApplication0 {

	public static void main(String[] args) {

		final String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

		final Observable<String> daysOfWeekSource = Observable.create(emitter -> {
			try {
				Stream.of(days).forEach(emitter::onNext);
				emitter.onComplete();
			} catch (Throwable exception) {
				emitter.onError(exception);
			}
		});

//		final Observable<String> daysOfWeekSource = Observable.just("Sunday", "Monday", "Tuesday", "Wednesday",
//				"Thursday", "Friday", "Saturday");

//		final List<String> days = Arrays.asList( "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" );
//		final Observable< String> daysOfWeekSource = Observable.fromIterable(days);

//		daysOfWeekSource.subscribe(day -> System.out.println("Today is " + day), Throwable::printStackTrace,
//				() -> System.out.println("Weekend begins!!"));

		final Observer<String> daysOfWeekObserver = new Observer<String>() {

			@Override
			public void onSubscribe(@NonNull Disposable disposable) {
				System.out.println("Week begins!!");
			}

			@Override
			public void onNext(@NonNull String day) {
				System.out.println("Today is " + day);
			}

			@Override
			public void onError(@NonNull Throwable exception) {
				exception.printStackTrace();
			}

			@Override
			public void onComplete() {
				System.out.println("Weekend begins!!");
			}

		};

		daysOfWeekSource.subscribe(daysOfWeekObserver);
	}
}
