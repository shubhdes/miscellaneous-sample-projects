package com.pattern.behavioral.chainofresponsibilities;

public class Manager extends Employee {

	public Manager(LeaveApprover successor) {
		super("Manager", successor);
	}

	@Override
	public boolean processRequest(LeaveApplication application) {
		if (application.getNumOfDays() <= 5) {
			return true;
		}
		return false;
	}
}
