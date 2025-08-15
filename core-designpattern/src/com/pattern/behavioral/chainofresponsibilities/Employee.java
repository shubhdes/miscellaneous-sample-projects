package com.pattern.behavioral.chainofresponsibilities;

public abstract class Employee implements LeaveApprover {

	private String role;

	private LeaveApprover successor;

	public Employee(String role, LeaveApprover successor) {
		this.role = role;
		this.successor = successor;
	}

	@Override
	public void processLeaveApplication(LeaveApplication application) {

		if (processRequest(application)) {
			application.setApprovedBy(getApproverRole());
			return;
		}
		successor.processLeaveApplication(application);
	}

	@Override
	public String getApproverRole() {
		return role;
	}

	public abstract boolean processRequest(LeaveApplication application);
}
