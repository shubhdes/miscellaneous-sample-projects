package com.kafka.dto;

public class Score {

	private int marks;

	public Score() {
		super();
	}

	public Score(int marks) {
		super();
		this.marks = marks;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Score [marks=" + marks + "]";
	}

}
