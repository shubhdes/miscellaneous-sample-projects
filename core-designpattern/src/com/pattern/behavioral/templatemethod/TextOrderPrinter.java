package com.pattern.behavioral.templatemethod;

import java.util.Map;

public class TextOrderPrinter extends OrderPrinter {

	@Override
	protected String start() {
		return "[";
	}

	@Override
	protected String formatId(Order order) {
		return "Id = " + order.getId();
	}

	@Override
	protected String formatItems(Order order) {

		StringBuilder builder = new StringBuilder();
		for (Map.Entry<String, Double> item : order.getItems().entrySet()) {
			builder.append("Name = " + item.getKey() + " Price = " + item.getValue());
			builder.append("\n");
		}

		return builder.toString();
	}

	@Override
	protected String formatTotal(Order order) {

		double total = 0;
		for (Map.Entry<String, Double> item : order.getItems().entrySet()) {
			total = total + item.getValue();
		}

		return "Total = " + total;
	}

	@Override
	protected String end() {
		return "]";
	}

}
