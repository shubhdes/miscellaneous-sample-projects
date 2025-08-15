package com.pattern.behavioral.command;

import java.util.LinkedList;
import java.util.Queue;

public class MailTaskRunner implements Runnable {

	private Queue<Command> queue = new LinkedList<>();

	public void addCommand(Command command) {
		queue.offer(command);
	}

	@Override
	public void run() {
		while (true) {
			while (!queue.isEmpty()) {
				Command command = queue.poll();
				command.execute();
			}
		}
	}
}
