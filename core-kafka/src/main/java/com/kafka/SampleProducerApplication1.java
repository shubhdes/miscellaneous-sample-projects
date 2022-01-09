package com.kafka;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.kafka.dto.Score;
import com.kafka.dto.Student;
import com.kafka.serdes.ScoreSampleSerializer;
import com.kafka.serdes.StudentSampleSerializer;

public class SampleProducerApplication1 {

	private static final String TOPIC_NAME = "my-topic-001";

	private static final String BOOTSTRAP_SERVERS_CONFIG = "localhost:9090,localhost:9091,localhost:9092";

	private final KafkaProducer<Student, Score> producer;

	public SampleProducerApplication1(Map<String, Object> propMap) {
		this.producer = new KafkaProducer<Student, Score>(propMap);
	}

	public static Map<String, Object> propMap() {
		final Map<String, Object> propMap = new HashMap<>();
		propMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_CONFIG);
		propMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StudentSampleSerializer.class);
		propMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ScoreSampleSerializer.class);
		return propMap;
	}

	public void pushMessageSync(Student student, Score score) {
		final ProducerRecord<Student, Score> record = new ProducerRecord<>(TOPIC_NAME, student, score);
		final Future<RecordMetadata> recordMetadataFut = producer.send(record);
		try {
			final RecordMetadata recordMetadata = recordMetadataFut.get();
			System.out.println("Student " + student.getName() + " , Score " + score.getMarks() + " pushed to Partition:"
					+ recordMetadata.partition() + ", Offset:" + recordMetadata.offset());
		} catch (InterruptedException | ExecutionException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		}
	}

	public void close() {
		producer.close();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.out.println("Producer application started!!");

		final Student student0 = new Student("john");
		final Student student1 = new Student("jack");
		final Student student2 = new Student("jill");

		final Score score0_0 = new Score(40);
		final Score score0_1 = new Score(15);
		final Score score1_0 = new Score(50);
		final Score score1_1 = new Score(25);
		final Score score2_0 = new Score(60);
		final Score score2_1 = new Score(35);

		final SampleProducerApplication1 producerApp = new SampleProducerApplication1(propMap());

		System.out.println("Producer application producing message record started!!");
		producerApp.pushMessageSync(student0, score0_0);
		producerApp.pushMessageSync(student0, score0_1);
		producerApp.pushMessageSync(student1, score1_0);
		producerApp.pushMessageSync(student1, score1_1);
		producerApp.pushMessageSync(student2, score2_0);
		producerApp.pushMessageSync(student2, score2_1);
		System.out.println("Producer application producing message record completed!!");

		producerApp.close();

		System.out.println("Producer application completed!!");
	}

}
