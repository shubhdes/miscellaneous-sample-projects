package com.pattern.behavioral.nullobject;

public class Report {

	private String name;

	private String contents;

	public Report(String name, String contents) {
		this.name = name;
		this.contents = contents;
	}

	public String getName() {
		return name;
	}

	public String getContents() {
		return contents;
	}
}
