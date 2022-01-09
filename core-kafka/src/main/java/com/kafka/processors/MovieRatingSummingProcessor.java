package com.kafka.processors;

import java.time.Duration;

import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.processor.PunctuationType;
import org.apache.kafka.streams.processor.api.Processor;
import org.apache.kafka.streams.processor.api.ProcessorContext;
import org.apache.kafka.streams.processor.api.Record;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.KeyValueStore;

public class MovieRatingSummingProcessor implements Processor<String, String, String, String> {

	private KeyValueStore<String, Long> movieRatingsStore;

	@Override
	public void init(final ProcessorContext<String, String> context) {
		this.movieRatingsStore = context.getStateStore("movieRatingsStore");
		context.schedule(Duration.ofSeconds(10), PunctuationType.STREAM_TIME, timestamp -> {
			final KeyValueIterator<String, Long> iterator = this.movieRatingsStore.all();
			while (iterator.hasNext()) {
				final KeyValue<String, Long> entry = iterator.next();
				context.forward(new Record<>(entry.key, entry.value.toString(), timestamp));
			}
			context.commit();
		});
	}

	@Override
	public void process(Record<String, String> record) {
		// TODO Auto-generated method stub
		final String movieName = record.key();
		final Long viewcount0 = Long.valueOf(record.value());
		final Long viewCount1 = movieRatingsStore.get(movieName);
		if (null == viewCount1) {
			movieRatingsStore.put(movieName, viewcount0);
		} else {
			movieRatingsStore.put(movieName, viewcount0 + viewCount1);
		}
	}

	@Override
	public void close() {

	}
}
