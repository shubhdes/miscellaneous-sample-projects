package com.pattern.creational.builder;

public class Client {

	public static void main(String[] args) {
		Person person = Person.getBuilder().withFirstName("java").withLastName("hub").withAge(27)
				.withEmail("hubjava98@gmail.com").build();
		System.out.println(person);
	}
}
