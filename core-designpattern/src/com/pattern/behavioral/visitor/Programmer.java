package com.pattern.behavioral.visitor;

public class Programmer extends AbstractEmployee {

	private String skill;

	public Programmer(String employeeId, String skill) {
		super(employeeId);
		this.skill = skill;
	}

	public String getSkill() {
		return skill;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
