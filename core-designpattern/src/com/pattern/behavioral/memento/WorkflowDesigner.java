package com.pattern.behavioral.memento;

import java.util.LinkedList;

public class WorkflowDesigner {

	private Workflow workflow;

	public WorkflowDesigner(String name) {
		this.workflow = new Workflow(name, new LinkedList<String>());
	}

	public Memento geMemento() {
		return new Memento(workflow.getName(), workflow.getSteps());
	}

	public void setMemento(Memento memento) {
		this.workflow = new Workflow(memento.getName(), new LinkedList<String>(memento.getSteps()));
	}

	public void addStep(String step) {
		workflow.getSteps().add(step);
	}

	public void show() {
		System.out.println(workflow.getSteps());
	}

	public class Memento {

		private String name;

		private LinkedList<String> steps;

		private Memento(String name, LinkedList<String> steps) {
			this.name = name;
			this.steps = new LinkedList<>(steps);
		}

		private String getName() {
			return name;
		}

		private LinkedList<String> getSteps() {
			return steps;
		}
	}
}
