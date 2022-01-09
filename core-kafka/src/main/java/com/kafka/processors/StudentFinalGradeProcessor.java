package com.kafka.processors;

import java.time.Duration;

import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.processor.PunctuationType;
import org.apache.kafka.streams.processor.api.Processor;
import org.apache.kafka.streams.processor.api.ProcessorContext;
import org.apache.kafka.streams.processor.api.Record;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.KeyValueStore;

import com.kafka.dto.Grade;
import com.kafka.dto.Score;
import com.kafka.dto.Student;

public class StudentFinalGradeProcessor implements Processor<Student, Score, Student, Grade> {

	private KeyValueStore<String, String> studentGradeStore;

	@Override
	public void init(final ProcessorContext<Student, Grade> context) {
		studentGradeStore = context.getStateStore("studentGradeStore");
		context.schedule(Duration.ofSeconds(30), PunctuationType.STREAM_TIME, timestamp -> {
			final KeyValueIterator<String, String> iterator = this.studentGradeStore.all();
			while (iterator.hasNext()) {
				final KeyValue<String, String> entry = iterator.next();
				final Student student0 = new Student(entry.key);
				final Grade grade0 = new Grade(entry.value);
				context.forward(new Record<>(student0, grade0, timestamp));
			}
			context.commit();
		});
	}

	@Override
	public void process(Record<Student, Score> record) {
		final Student student = record.key();
		final Score score0 = record.value();
		final Integer marks = score0.getMarks();
		String grade = null;
		if (marks >= 90) {
			grade = "A+";
		} else if (marks >= 75) {
			grade = "A";
		} else if (marks >= 60) {
			grade = "B";
		} else if (marks >= 40) {
			grade = "C";
		} else {
			grade = "D";
		}
		studentGradeStore.put(student.getName().toString(), grade);
	}

	@Override
	public void close() {

	}
}
