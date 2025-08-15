package com.pattern.behavioral.command;

public class Client {

	public static void main(String[] args) {

		EWSService receiver = new EWSService();
		Command addMemberCommand = new AddMemberCommand("durga@gmail.com", "durgasoftware", receiver);

		MailTaskRunner invoker = new MailTaskRunner();
		invoker.addCommand(addMemberCommand);

		new Thread(invoker).start();
	}
}
