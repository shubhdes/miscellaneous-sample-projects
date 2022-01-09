package com.kafka;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.kafka.dto.Grade;
import com.kafka.dto.Student;
import com.kafka.serdes.GradeSampleDeserializer;
import com.kafka.serdes.StudentSampleDeserializer;

public class SampleConsumerApplication1 {

	private static final String TOPIC_NAME = "my-topic-002";

	private static final String GROUP_NAME = "my-group-002";

	private static final String BOOTSTRAP_SERVERS_CONFIG = "localhost:9090,localhost:9091,localhost:9092";

	private static final int TIME_OUT_DURATION = 100;

	private final KafkaConsumer<Student, Grade> consumer;

	public SampleConsumerApplication1(Map<String, Object> propMap) {
		this.consumer = new KafkaConsumer<Student, Grade>(propMap);
	}

	public static Map<String, Object> propMap() {
		final Map<String, Object> propMap = new HashMap<>();
		propMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_CONFIG);
		propMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StudentSampleDeserializer.class);
		propMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, GradeSampleDeserializer.class);
		propMap.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_NAME);
		propMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, Boolean.FALSE.toString());
		return propMap;
	}

	public void pullMessage() {
		consumer.subscribe(Arrays.asList(TOPIC_NAME));
		final Duration timeOutDuration = Duration.of(TIME_OUT_DURATION, ChronoUnit.MILLIS);
		while (true) {
			ConsumerRecords<Student, Grade> records = consumer.poll(timeOutDuration);
			records.forEach((record) -> {
				System.out.println("Student " + record.key().getName() + ", Grade " + record.value().getName()
						+ " pulled from Partition:" + record.partition() + ", Offset:" + record.offset());
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
		System.out.println("Consumer application started!!");

		final SampleConsumerApplication1 consumerApp = new SampleConsumerApplication1(propMap());

		System.out.println("Consumer application consuming message record started!!");

		consumerApp.pullMessage();

		System.out.println("Consumer application consuming message record completed!!");

		consumerApp.close();

		System.out.println("Consumer application completed!!");
	}
}
