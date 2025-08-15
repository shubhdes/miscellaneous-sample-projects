package com.pattern.behavioral.strategy;

import java.util.Map;

public class DetailPrinter implements OrderPrinter {

	@Override
	public String print(Order order) {

		StringBuilder builder = new StringBuilder();
		builder.append("Id = ").append(order.getId())
				.append(" Date = " + order.getDate() + " Items = " + order.getItems().size());
		builder.append("\n");

		double total = 0;
		for (Map.Entry<String, Double> item : order.getItems().entrySet()) {
			builder.append("Name = " + item.getKey() + " Price = " + item.getValue());
			builder.append("\n");
			total = total + item.getValue();
		}

		builder.append("Total = " + total);

		return builder.toString();
	}
}
