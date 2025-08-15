package com.pattern.behavioral.command;

public class RemoveMemberCommand implements Command {

	private String email;

	private String group;

	private EWSService receiver;

	public RemoveMemberCommand(String email, String group, EWSService receiver) {
		this.email = email;
		this.group = group;
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.removeMember(email, group);
	}
}
