package com.kafka.serdes;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.dto.Student;

public class StudentSampleSerializer implements Serializer<Student> {

	@Override
	public byte[] serialize(String topic, Student student) {
		// TODO Auto-generated method stub
		byte[] bytes = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			bytes = mapper.writeValueAsString(student).getBytes();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bytes;
	}
}
