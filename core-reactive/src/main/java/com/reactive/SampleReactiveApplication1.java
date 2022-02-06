package com.reactive;

import io.reactivex.rxjava3.core.Completable;

public class SampleReactiveApplication1 {

	public static void main(String[] args) {

//		final SingleSource<String> source = Single.just("Learning reactive programming is fun!!");
//		final SingleObserver<String> singleObserver = new SingleObserver<String>() {
//
//			@Override
//			public void onSubscribe(@NonNull Disposable d) {
//				System.out.println("Observer subscribed!!");
//			}
//
//			@Override
//			public void onSuccess(@NonNull String data) {
//				System.out.println("Observer received event " + data);
//			}
//
//			@Override
//			public void onError(@NonNull Throwable exception) {
//				exception.printStackTrace();
//			}
//		};
//		source.subscribe(singleObserver);

//		Single.just("Learning reactive programming is fun!!").subscribe(System.out::println,
//				(exception) -> exception.printStackTrace());

//		final MaybeSource<String> source = Maybe.empty();
//		final MaybeSource<String> source = Maybe.just("Learning reactive programming is fun!!");
//		final MaybeObserver<String> singleObserver = new MaybeObserver<String>() {
//
//			@Override
//			public void onSubscribe(@NonNull Disposable d) {
//				System.out.println("Observer subscribed!!");
//			}
//
//			@Override
//			public void onSuccess(@NonNull String data) {
//				System.out.println("Observer received event " + data);
//			}
//
//			@Override
//			public void onError(@NonNull Throwable exception) {
//				exception.printStackTrace();
//			}
//
//			@Override
//			public void onComplete() {
//				System.out.println("Observer consumed all events!!");
//			}
//		};
//		source.subscribe(singleObserver);

//		Maybe.just("Learning reactive programming is fun!!").subscribe(System.out::println,
//				(exception) -> exception.printStackTrace(), () -> System.out.println("Observer consumed all events!!"));

		Completable.fromRunnable(() -> {
			for (int i = 1; i <= 100; i++) {
				System.out.println(i);
			}
		}).subscribe(() -> System.out.println("Observer consumed all events!!"), Throwable::printStackTrace);
	}
}
