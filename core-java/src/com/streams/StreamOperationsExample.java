package com.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamOperationsExample {

	public static void main(String[] args) {

		List<Employee> empList = Arrays.asList(new Employee(1001L, "john", 23400.56d, "Finance"),
				new Employee(1002L, "jack", 43400.18d, "Engineering"), new Employee(1003L, "alice", 13450.36d, "HR"),
				new Employee(1004L, "bob", 33400.52d, "Engineering"), new Employee(1005L, "david", 3400.76d, "HR"));

//		empList.stream().filter(emp -> emp.getSalary() > 15000d).forEach(System.out::println);

//		empList.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);

//		empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(System.out::println);

//		Map<String, List<Employee>> empMap = empList.stream().collect(Collectors.groupingBy(Employee::getDept));
//		System.out.println(empMap);

//		Map<String, Long> empMap = empList.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));
//		System.out.println(empMap);

		System.out.println(empList.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.counting())));

		System.out.println(empList.stream().collect(Collectors.groupingBy(Employee::getDept)));

		System.out.println(empList.stream().sorted(Comparator.comparing(Employee::getName).reversed())
				.collect(Collectors.toList()));
	}
}
