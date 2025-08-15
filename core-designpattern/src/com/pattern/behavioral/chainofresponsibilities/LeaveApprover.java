package com.pattern.behavioral.chainofresponsibilities;

public interface LeaveApprover {

	void processLeaveApplication(LeaveApplication application);

	String getApproverRole();
}
