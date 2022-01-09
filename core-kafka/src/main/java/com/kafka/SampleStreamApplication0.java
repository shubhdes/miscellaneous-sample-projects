package com.kafka;

import java.util.Properties;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.state.Stores;

import com.kafka.processors.MovieRatingSummingProcessor;

public class SampleStreamApplication0 {

	private static final String INPUT_TOPIC_NAME = "my-topic-001";

	private static final String OUTPUT_TOPIC_NAME = "my-topic-002";

	private static final String APPLICATION_ID_CONFIG = "sampleKafkaStreamExample";

	private static final String BOOTSTRAP_SERVERS_CONFIG = "localhost:9090,localhost:9091,localhost:9092";

	private static final String SOURCE = "source";

	private static final String PROCESSOR_0 = "processor0";

	private static final String STATE_STORE = "movieRatingsStore";

	private static final String SINK = "sink";

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		createStream(streamsConfiguration(), topology());
	}

	public static Properties streamsConfiguration() {
		final Properties streamsConfiguration = new Properties();
		streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, APPLICATION_ID_CONFIG);
		streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_CONFIG);
		return streamsConfiguration;
	}

	public static Topology topology() {
		final Serde<String> stringSerdes = Serdes.String();
		final Serde<Long> longSerdes = Serdes.Long();
		final Topology topology = new Topology();
		topology.addSource(SOURCE, stringSerdes.deserializer(), stringSerdes.deserializer(), INPUT_TOPIC_NAME)
				.addProcessor(PROCESSOR_0, MovieRatingSummingProcessor::new, SOURCE)
				.addStateStore(Stores.keyValueStoreBuilder(Stores.inMemoryKeyValueStore(STATE_STORE), stringSerdes,
						longSerdes), PROCESSOR_0)
				.addSink(SINK, OUTPUT_TOPIC_NAME, stringSerdes.serializer(), stringSerdes.serializer(), PROCESSOR_0);
		return topology;
	}

	public static void createStream(Properties streamsConfiguration, Topology topology) throws InterruptedException {
		final KafkaStreams stream = new KafkaStreams(topology, streamsConfiguration);
		stream.start();
		Thread.sleep(60000);
		stream.close();
	}
}
