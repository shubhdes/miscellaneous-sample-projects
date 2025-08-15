package com.pattern.behavioral.visitor;

public class PrintVisitor implements Visitor {

	@Override
	public void visit(Programmer programmer) {
		System.out.println("Employee " + programmer.getEmployeeId() + " is a " + programmer.getSkill() + " programmer");
	}

	@Override
	public void visit(ProjectLead projectLead) {
		System.out.println("Employee " + projectLead.getEmployeeId() + " is a project lead with "
				+ projectLead.getDirectReports().size() + " direct reportees");
	}

	@Override
	public void visit(Manager manager) {
		System.out.println("Employee " + manager.getEmployeeId() + " is a manager with "
				+ manager.getDirectReports().size() + " direct reportees");
	}

	@Override
	public void visit(VicePresident vicePresident) {
		System.out.println("Employee " + vicePresident.getEmployeeId() + " is a vice president with "
				+ vicePresident.getDirectReports().size() + " direct reportees");
	}
}
