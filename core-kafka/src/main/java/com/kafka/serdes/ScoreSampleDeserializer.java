package com.kafka.serdes;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.dto.Score;

public class ScoreSampleDeserializer implements Deserializer<Score> {

	@Override
	public Score deserialize(String topic, byte[] data) {
		// TODO Auto-generated method stub
		Score score = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			score = mapper.readValue(data, Score.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return score;
	}
}
