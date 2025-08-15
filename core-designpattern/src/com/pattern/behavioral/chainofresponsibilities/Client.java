package com.pattern.behavioral.chainofresponsibilities;

public class Client {

	public static void main(String[] args) {
		Director director = new Director(null);
		Manager manager = new Manager(director);
		Lead lead = new Lead(manager);

		LeaveApplication application = new LeaveApplication(4);
		lead.processLeaveApplication(application);
		System.out.println(application.getApprovedBy());
	}
}
