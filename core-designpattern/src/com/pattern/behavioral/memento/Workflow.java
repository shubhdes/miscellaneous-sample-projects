package com.pattern.behavioral.memento;

import java.util.LinkedList;

public class Workflow {

	private String name;

	private LinkedList<String> steps;

	public Workflow(String name, LinkedList<String> steps) {
		this.name = name;
		this.steps = new LinkedList<>(steps);
	}

	public String getName() {
		return name;
	}

	public LinkedList<String> getSteps() {
		return steps;
	}
}
