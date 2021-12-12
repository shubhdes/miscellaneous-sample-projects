package com.kafka;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class SampleConsumerApplication {

	private static final String TOPIC_NAME = "my-topic-002";

	private static final String GROUP_NAME = "my-group-002";

	private static final String BOOTSTRAP_SERVERS_CONFIG = "localhost:9090,localhost:9091,localhost:9092";

	private static final int TIME_OUT_DURATION = 100;

	private KafkaConsumer<String, String> consumer;

	public SampleConsumerApplication(Map<String, Object> propMap) {
		this.consumer = new KafkaConsumer<String, String>(propMap);
	}

	public static Map<String, Object> propMap() {
		Map<String, Object> propMap = new HashMap<>();
		propMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_CONFIG);
		propMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		propMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		propMap.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_NAME);
		propMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, Boolean.FALSE.toString());
		return propMap;
	}

	public void pullMessage() {
		consumer.subscribe(Arrays.asList(TOPIC_NAME));
		Duration timeOutDuration = Duration.of(TIME_OUT_DURATION, ChronoUnit.MILLIS);
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(timeOutDuration);
			records.forEach((record) -> {
				System.out.println("Value:" + record.value());
				System.out.println("Partition:" + record.partition());
				System.out.println("Offset:" + record.offset());
			});

			if (records.count() > 0) {
				consumer.commitSync();
			}
		}
	}

	public void close() {
		consumer.close();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		SampleConsumerApplication consumerApp = new SampleConsumerApplication(propMap());
		consumerApp.pullMessage();
		consumerApp.close();
	}
}
