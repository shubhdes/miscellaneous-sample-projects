package com.pattern.behavioral.visitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProjectLead extends AbstractEmployee {

	private List<Employee> directReportees;

	public ProjectLead(String employeeId, List<Employee> directReportees) {
		super(employeeId);
		this.directReportees = new ArrayList<>(directReportees);
	}

	@Override
	public Collection<Employee> getDirectReports() {
		return directReportees;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
