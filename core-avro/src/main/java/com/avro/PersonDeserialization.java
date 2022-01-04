package com.avro;

import java.io.File;
import java.io.IOException;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;

import com.avro.entities.Person;

public class PersonDeserialization {

	public Person deserialize() throws IOException {
		final File file = new File("person.avro");
		final DatumReader<Person> personReader = new SpecificDatumReader<>(Person.class);
		final DataFileReader<Person> dataFileReader = new DataFileReader<>(file, personReader);
		try {
			Person person = null;
			while (dataFileReader.hasNext()) {
				person = dataFileReader.next(new Person());
				break;
			}
			return person;
		} finally {
			dataFileReader.close();
		}
	}
}
