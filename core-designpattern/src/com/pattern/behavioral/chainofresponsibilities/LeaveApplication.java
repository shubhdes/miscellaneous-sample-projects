package com.pattern.behavioral.chainofresponsibilities;

public class LeaveApplication {

	private int numOfDays;

	private String approvedBy;

	public LeaveApplication(int numOfDays) {
		this.numOfDays = numOfDays;
	}

	public int getNumOfDays() {
		return numOfDays;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getApprovedBy() {
		return approvedBy;
	}
}
