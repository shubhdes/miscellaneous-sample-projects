package com.pattern.behavioral.memento;

public class AddWorkflowCommand implements WorkflowCommand {

	private WorkflowDesigner orignator;

	private WorkflowDesigner.Memento memento;

	private String step;

	public AddWorkflowCommand(WorkflowDesigner orignator, String step) {
		this.orignator = orignator;
		this.step = step;
	}

	@Override
	public void execute() {
		this.memento = orignator.geMemento();
		orignator.addStep(step);
	}

	@Override
	public void undo() {
		orignator.setMemento(memento);
	}
}
