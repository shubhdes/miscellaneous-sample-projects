package com.pattern.behavioral.visitor;

import java.util.Collection;

public interface Employee {

	String getEmployeeId();

	int getPerformanceRating();

	void setPerformanceRating(int performanceRating);

	Collection<Employee> getDirectReports();

	void accept(Visitor visitor);
}
