package com.pattern.behavioral.templatemethod;

import java.util.Map;

public class HtmlOrderPrinter extends OrderPrinter {

	@Override
	protected String start() {
		return "<html><head><title>Order Details</title></head><body>";
	}

	@Override
	protected String formatId(Order order) {
		return "<b>Id = " + order.getId() + "</b>";
	}

	@Override
	protected String formatItems(Order order) {

		StringBuilder builder = new StringBuilder();
		builder.append("<table><th><td>Name</td><td>Price</td></th>");

		for (Map.Entry<String, Double> item : order.getItems().entrySet()) {
			builder.append("<tr>");
			builder.append("<td>" + item.getKey() + "</td><td>" + item.getValue() + "<td>");
			builder.append("</tr>");
		}
		builder.append("</table>");
		return builder.toString();
	}

	@Override
	protected String formatTotal(Order order) {

		double total = 0;
		for (Map.Entry<String, Double> item : order.getItems().entrySet()) {
			total = total + item.getValue();
		}

		return "<b>Total = " + total + "</b>";
	}

	@Override
	protected String end() {
		return "</body></html>";
	}

}
