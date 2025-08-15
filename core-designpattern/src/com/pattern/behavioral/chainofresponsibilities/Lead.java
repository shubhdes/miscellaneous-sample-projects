package com.pattern.behavioral.chainofresponsibilities;

public class Lead extends Employee {

	public Lead(LeaveApprover successor) {
		super("Lead", successor);
	}

	@Override
	public boolean processRequest(LeaveApplication application) {
		if (application.getNumOfDays() <= 2) {
			return true;
		}
		return false;
	}
}
