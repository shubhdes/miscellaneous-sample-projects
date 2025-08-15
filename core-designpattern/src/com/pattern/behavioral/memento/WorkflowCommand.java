package com.pattern.behavioral.memento;

public interface WorkflowCommand {

	public void execute();

	public void undo();
}
