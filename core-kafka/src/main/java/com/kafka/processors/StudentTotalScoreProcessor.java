package com.kafka.processors;

import java.time.Duration;

import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.processor.PunctuationType;
import org.apache.kafka.streams.processor.api.Processor;
import org.apache.kafka.streams.processor.api.ProcessorContext;
import org.apache.kafka.streams.processor.api.Record;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.KeyValueStore;

import com.kafka.dto.Score;
import com.kafka.dto.Student;

public class StudentTotalScoreProcessor implements Processor<Student, Score, Student, Score> {

	private KeyValueStore<String, Integer> studentScoreStore;

	@Override
	public void init(final ProcessorContext<Student, Score> context) {
		studentScoreStore = context.getStateStore("studentScoreStore");
		context.schedule(Duration.ofSeconds(10), PunctuationType.STREAM_TIME, timestamp -> {
			final KeyValueIterator<String, Integer> iterator = this.studentScoreStore.all();
			while (iterator.hasNext()) {
				final KeyValue<String, Integer> entry = iterator.next();
				final Student student0 = new Student(entry.key);
				final Score score0 = new Score(entry.value);
				context.forward(new Record<>(student0, score0, timestamp));
			}
			context.commit();
		});
	}

	@Override
	public void process(Record<Student, Score> record) {
		final Student student0 = record.key();
		final Score score0 = record.value();
		final Integer score1 = studentScoreStore.get(student0.getName().toString());
		if (null == score1) {
			studentScoreStore.put(student0.getName().toString(), score0.getMarks());
		} else {
			studentScoreStore.put(student0.getName().toString(), score0.getMarks() + score1);
		}
	}

	@Override
	public void close() {

	}
}
