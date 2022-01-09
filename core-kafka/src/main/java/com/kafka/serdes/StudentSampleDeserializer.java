package com.kafka.serdes;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.dto.Student;

public class StudentSampleDeserializer implements Deserializer<Student> {

	@Override
	public Student deserialize(String topic, byte[] data) {
		// TODO Auto-generated method stub
		Student student = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			student = mapper.readValue(data, Student.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return student;
	}
}
