package com.kafka.serdes;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.dto.Score;

public class ScoreSampleSerializer implements Serializer<Score> {

	@Override
	public byte[] serialize(String topic, Score score) {
		// TODO Auto-generated method stub
		byte[] bytes = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			bytes = mapper.writeValueAsString(score).getBytes();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bytes;
	}
}
