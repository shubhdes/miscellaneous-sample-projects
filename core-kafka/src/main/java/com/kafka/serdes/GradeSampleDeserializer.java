package com.kafka.serdes;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.dto.Grade;

public class GradeSampleDeserializer implements Deserializer<Grade> {

	@Override
	public Grade deserialize(String topic, byte[] data) {
		// TODO Auto-generated method stub
		Grade grade = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			grade = mapper.readValue(data, Grade.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return grade;
	}
}
