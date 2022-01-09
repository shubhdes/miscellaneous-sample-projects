package com.kafka.processors;

import org.apache.kafka.streams.processor.api.Processor;
import org.apache.kafka.streams.processor.api.ProcessorContext;
import org.apache.kafka.streams.processor.api.Record;

public class MovieRatingPlainProcessor implements Processor<String, String, String, String> {

	private ProcessorContext<String, String> context;

	@Override
	public void init(final ProcessorContext<String, String> context) {
		this.context = context;
	}

	@Override
	public void process(Record<String, String> record) {
		// TODO Auto-generated method stub
		this.context.forward(record);
		this.context.commit();
	}
}
