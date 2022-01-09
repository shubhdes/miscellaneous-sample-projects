package com.kafka;

import java.util.Properties;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.state.Stores;

import com.kafka.processors.StudentFinalGradeProcessor;
import com.kafka.processors.StudentTotalScoreProcessor;
import com.kafka.serdes.GradeSampleSerializer;
import com.kafka.serdes.ScoreSampleDeserializer;
import com.kafka.serdes.StudentSampleDeserializer;
import com.kafka.serdes.StudentSampleSerializer;

public class SampleStreamApplication1 {

	private static final String INPUT_TOPIC_NAME = "my-topic-001";

	private static final String OUTPUT_TOPIC_NAME = "my-topic-002";

	private static final String APPLICATION_ID_CONFIG = "sampleKafkaStreamExample";

	private static final String BOOTSTRAP_SERVERS_CONFIG = "localhost:9090,localhost:9091,localhost:9092";

	private static final String SOURCE = "source";

	private static final String PROCESSOR_0 = "processor0";

	private static final String STATE_STORE_0 = "studentScoreStore";

	private static final String PROCESSOR_1 = "processor1";

	private static final String STATE_STORE_1 = "studentGradeStore";

	private static final String SINK = "sink";

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Streaming application started!!");

		createStream(streamsConfiguration(), topology());

		System.out.println("Streaming application completed!!");
	}

	public static Properties streamsConfiguration() {
		final Properties streamsConfiguration = new Properties();
		streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, APPLICATION_ID_CONFIG);
		streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_CONFIG);
		return streamsConfiguration;
	}

	public static Topology topology() {
		final Serde<String> stringSerdes = Serdes.String();
		final Serde<Integer> intSerdes = Serdes.Integer();
		final Topology topology = new Topology();
		topology.addSource(SOURCE, new StudentSampleDeserializer(), new ScoreSampleDeserializer(), INPUT_TOPIC_NAME)
				.addProcessor(PROCESSOR_0, StudentTotalScoreProcessor::new, SOURCE)
				.addStateStore(Stores.keyValueStoreBuilder(Stores.inMemoryKeyValueStore(STATE_STORE_0), stringSerdes,
						intSerdes), PROCESSOR_0)
				.addProcessor(PROCESSOR_1, StudentFinalGradeProcessor::new, PROCESSOR_0)
				.addStateStore(Stores.keyValueStoreBuilder(Stores.inMemoryKeyValueStore(STATE_STORE_1), stringSerdes,
						stringSerdes), PROCESSOR_1)
				.addSink(SINK, OUTPUT_TOPIC_NAME, new StudentSampleSerializer(), new GradeSampleSerializer(),
						PROCESSOR_1);
		return topology;
	}

	public static void createStream(Properties streamsConfiguration, Topology topology) throws InterruptedException {
		final KafkaStreams stream = new KafkaStreams(topology, streamsConfiguration);
		stream.start();
		Thread.sleep(60000);
		stream.close();
	}
}
