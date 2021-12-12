package com.kafka;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

public class SampleProducerApplication {

	private static final String TOPIC_NAME = "my-topic-002";

	private static final String BOOTSTRAP_SERVERS_CONFIG = "localhost:9090,localhost:9091,localhost:9092";

	private static final int SLEEP_INTERVAL = 5000;

	private KafkaProducer<String, String> producer;

	private Callback callback;

	public SampleProducerApplication(Map<String, Object> propMap) {
		this.producer = new KafkaProducer<String, String>(propMap);
		callback = (recordMetadata, exception) -> {
			if (null != exception) {
				exception.printStackTrace();
			} else {
				System.out.println("Partition:" + recordMetadata.partition());
				System.out.println("Offset:" + recordMetadata.offset());
			}
		};
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
		} catch (InterruptedException | ExecutionException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		}
	}

	public void pushMessageAsync(String msgKey, String msgValue) {
		ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, msgKey, msgValue);
		producer.send(record, this.callback);
	}

	public void close() {
		producer.close();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		SampleProducerApplication producerApp = new SampleProducerApplication(propMap());
//		producerApp.pushMessageSync("1.0", "Welcome to world of Apache Kafka!!");
//		producerApp.pushMessageSync("2.0", "Learning Apache Kafka is fun!!");
//		producerApp.pushMessageSync("1.0", "Welcome to first producer program!!");

		producerApp.pushMessageAsync("1.0", "Welcome to world of Apache Kafka!!");
		producerApp.pushMessageAsync("2.0", "Learning Apache Kafka is fun!!");
		producerApp.pushMessageAsync("1.0", "Welcome to first producer program!!");

		Thread.sleep(SLEEP_INTERVAL);

		producerApp.close();
	}

}
