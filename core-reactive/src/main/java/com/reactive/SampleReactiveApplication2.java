package com.reactive;

import java.util.Comparator;

import com.reactive.dto.Employee;

import io.reactivex.rxjava3.core.Observable;

public class SampleReactiveApplication2 {

	public static void main(String[] args) {

		Observable<Employee> source = Observable.just(new Employee(1001, "john", 2.3f),
				new Employee(1002, "jack", 3.3f), new Employee(1003, "alice", 4.1f), new Employee(1004, "bob", 4.5f),
				new Employee(1005, "smith", 4.6f), new Employee(1006, "joy", 2.1f), new Employee(1007, "joe", 2.3f),
				new Employee(1008, "jose", 4.3f), new Employee(1009, "tom", 4.4f), new Employee(1010, "harry", 1.2f));

		source.filter(employee -> employee.getRating() > 4.0f)
				.sorted(Comparator.comparingDouble(Employee::getRating).reversed()).map(employee -> employee.getName())
				.take(3).subscribe(System.out::println);
	}
}
