package com.pattern.behavioral.visitor;

import java.util.Collection;
import java.util.Collections;

public abstract class AbstractEmployee implements Employee {

	private String employeeId;

	private int performanceRating;

	public AbstractEmployee(String employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public int getPerformanceRating() {
		return performanceRating;
	}

	@Override
	public void setPerformanceRating(int performanceRating) {
		this.performanceRating = performanceRating;

	}

	@Override
	public Collection<Employee> getDirectReports() {
		return Collections.emptyList();
	}

	@Override
	public String getEmployeeId() {
		return employeeId;
	}
}
