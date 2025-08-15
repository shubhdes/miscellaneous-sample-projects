package com.pattern.structural.adapter;

public class BusinessCardDesigner {

	public String designCard(Customer customer) {
		return customer.getName() + " works as " + customer.getDesignation() + " at " + customer.getAddress();
	}
}
