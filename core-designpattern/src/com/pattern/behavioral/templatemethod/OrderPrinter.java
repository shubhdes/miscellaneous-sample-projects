package com.pattern.behavioral.templatemethod;

public abstract class OrderPrinter {

	public void printOrder(Order order) {

		StringBuilder builder = new StringBuilder();
		builder.append(start()).append(formatId(order)).append(formatItems(order)).append(formatTotal(order))
				.append(end());

		System.out.println(builder);
	}

	protected abstract String start();

	protected abstract String formatId(Order order);

	protected abstract String formatItems(Order order);

	protected abstract String formatTotal(Order order);

	protected abstract String end();

}
