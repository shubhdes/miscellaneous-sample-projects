package com.kafka.serdes;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.dto.Grade;

public class GradeSampleSerializer implements Serializer<Grade> {

	@Override
	public byte[] serialize(String topic, Grade grade) {
		// TODO Auto-generated method stub
		byte[] bytes = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			bytes = mapper.writeValueAsString(grade).getBytes();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bytes;
	}
}
