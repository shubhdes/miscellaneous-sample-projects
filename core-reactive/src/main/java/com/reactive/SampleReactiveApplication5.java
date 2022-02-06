package com.reactive;

import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class SampleReactiveApplication5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subject<String> subject = PublishSubject.create();
		subject = subject.toSerialized();
	}
}
