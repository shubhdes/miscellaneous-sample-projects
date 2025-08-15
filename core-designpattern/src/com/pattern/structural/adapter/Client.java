package com.pattern.structural.adapter;

public class Client {

	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setFullName("Java Hub");
		emp.setJobTitle("Software Developer");
		emp.setOfficeLocation("India");
		Customer customer = new EmployeeObjectAdapter(emp);
		BusinessCardDesigner businessCardDesigner = new BusinessCardDesigner();
		String card = businessCardDesigner.designCard(customer);
		System.out.println(card);
	}
}
