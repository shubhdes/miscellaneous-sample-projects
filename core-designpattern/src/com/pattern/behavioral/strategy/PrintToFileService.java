package com.pattern.behavioral.strategy;

public class PrintToFileService {

	private OrderPrinter orderPrinter;

	public PrintToFileService(OrderPrinter orderPrinter) {
		this.orderPrinter = orderPrinter;
	}

	public void printOrder(Order order) {
		System.out.println(orderPrinter.print(order));
	}

}
