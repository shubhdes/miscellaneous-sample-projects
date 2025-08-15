package com.pattern.behavioral.strategy;

import java.time.LocalDate;

public class Client {

	public static void main(String[] args) {

		Order order = new Order("O001", LocalDate.now());
		order.addItem("chips", 120);
		order.addItem("cookies", 746);
		order.addItem("soda", 180);
		order.addItem("fries", 780);

		OrderPrinter orderPrinter = new DetailPrinter();
		PrintToFileService service = new PrintToFileService(orderPrinter);
		service.printOrder(order);
	}
}
