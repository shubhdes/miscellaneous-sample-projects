package com.avro;

import java.io.IOException;

import com.avro.entities.Address;
import com.avro.entities.Person;

public class Application {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Person person0 = new Person("Shubham", 25, new Address("Mumbai", "Mumbai", "Mumbai", "400097", "MH", "IN"));

		PersonSerialization pserialize = new PersonSerialization();
		pserialize.serialize(person0);
		System.out.println("Serialization completed!!");

		PersonDeserialization pdeserialize = new PersonDeserialization();
		Person person1 = pdeserialize.deserialize();
		System.out.println("Deserialization completed!!");

		System.out.println("Person:" + person1);
	}

}
