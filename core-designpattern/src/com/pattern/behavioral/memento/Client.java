package com.pattern.behavioral.memento;

public class Client {

	public static void main(String[] args) {

		WorkflowDesigner orignator = new WorkflowDesigner("Leave workflow");

		WorkflowCommand command1 = new AddWorkflowCommand(orignator, "Create Leave Application");
		WorkflowCommand command2 = new AddWorkflowCommand(orignator, "Submit Leave Application");
		WorkflowCommand command3 = new AddWorkflowCommand(orignator, "Leave Application Approved");

		command1.execute();
		command2.execute();
		command3.execute();

		orignator.show();
		command3.undo();
		orignator.show();
	}
}
