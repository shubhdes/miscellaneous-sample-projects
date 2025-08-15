package com.pattern.behavioral.visitor;

import java.util.List;

public class Client {

	public static void main(String[] args) {

		Employee emp = buildOrganisation();
		Visitor visitor = new PrintVisitor();

		visitOrganisation(emp, visitor);
	}

	public static Employee buildOrganisation() {

		Programmer programmer1 = new Programmer("PG001", "c");
		Programmer programmer2 = new Programmer("PG002", "c++");
		Programmer programmer3 = new Programmer("PG003", "java");
		Programmer programmer4 = new Programmer("PG004", "python");

		ProjectLead projectLead1 = new ProjectLead("PL001", List.of(programmer1, programmer2));
		ProjectLead projectLead2 = new ProjectLead("PL002", List.of(programmer3, programmer4));

		Manager manager1 = new Manager("MG001", List.of(projectLead1, projectLead2));

		VicePresident vicePresident = new VicePresident("VP001", List.of(manager1));

		return vicePresident;
	}

	public static void visitOrganisation(Employee emp, Visitor visitor) {
		emp.accept(visitor);
		emp.getDirectReports().forEach(reportee -> visitOrganisation(reportee, visitor));
	}
}
