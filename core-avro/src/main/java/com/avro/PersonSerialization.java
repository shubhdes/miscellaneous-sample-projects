package com.avro;

import java.io.File;
import java.io.IOException;

import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;

import com.avro.entities.Person;

public class PersonSerialization {

	public void serialize(Person person) throws IOException {
		final DatumWriter<Person> datumWriter = new SpecificDatumWriter<>(Person.class);
		final DataFileWriter<Person> dataFileWriter = new DataFileWriter<>(datumWriter);
		dataFileWriter.create(person.getSchema(), new File("person.avro"));
		try {
			dataFileWriter.append(person);
		} finally {
			dataFileWriter.close();
		}
	}
}
