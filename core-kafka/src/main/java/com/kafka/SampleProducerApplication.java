package com.kafka;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

public class SampleProducerApplication {

	private static final String TOPIC_NAME = "my-topic-002";

	private static final String BOOTSTRAP_SERVERS_CONFIG = "localhost:9090,localhost:9091,localhost:9092";

	private KafkaProducer<String, String> producer;

	public SampleProducerApplication(Map<String, Object> propMap) {
		this.producer = new KafkaProducer<String, String>(propMap);
	}

	public static Map<String, Object> propMap() {
		Map<String, Object> propMap = new HashMap<>();
		propMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_CONFIG);
		propMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		propMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		return propMap;
	}

	public void pushMessageSync(String msgKey, String msgValue) {
		ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, msgKey, msgValue);
		Future<RecordMetadata> recordMetadataFut = producer.send(record);
		try {
			RecordMetadata recordMetadata = recordMetadataFut.get();
			System.out.println("Partition:" + recordMetadata.partition());
			System.out.println("Offset:" + recordMetadata.offset());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SampleProducerApplication producerApp = new SampleProducerApplication(propMap());
		producerApp.pushMessageSync("1.0", "Welcome to world of Apache Kafka!!");
		producerApp.pushMessageSync("2.0", "Learning Apache Kafka is fun!!");
		producerApp.pushMessageSync("1.0", "Welcome to first producer program!!");
	}

}
