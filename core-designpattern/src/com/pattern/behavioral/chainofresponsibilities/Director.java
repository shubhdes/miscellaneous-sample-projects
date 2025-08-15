package com.pattern.behavioral.chainofresponsibilities;

public class Director extends Employee {

	public Director(LeaveApprover successor) {
		super("Director", successor);
	}

	@Override
	public boolean processRequest(LeaveApplication application) {
		return true;
	}
}
