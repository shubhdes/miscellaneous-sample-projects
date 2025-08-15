package com.pattern.behavioral.command;

public class AddMemberCommand implements Command {

	private String email;

	private String group;

	private EWSService receiver;

	public AddMemberCommand(String email, String group, EWSService receiver) {
		this.email = email;
		this.group = group;
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.addMember(email, group);
	}
}
