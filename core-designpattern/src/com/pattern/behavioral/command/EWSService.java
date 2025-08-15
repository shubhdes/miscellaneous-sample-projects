package com.pattern.behavioral.command;

public class EWSService {

	public void addMember(String contact, String contactGroup) {
		System.out.println("Added member " + contact + " to group " + contactGroup);
	}

	public void removeMember(String contact, String contactGroup) {
		System.out.println("Removed member " + contact + " to group " + contactGroup);
	}
}
