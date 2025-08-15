package com.pattern.behavioral.strategy;

public class SummaryPrinter implements OrderPrinter {

	@Override
	public String print(Order order) {
		StringBuilder builder = new StringBuilder();
		return builder.append("Id = ").append(order.getId())
				.append(" Date = " + order.getDate() + " Items = " + order.getItems().size()).toString();
	}
}
