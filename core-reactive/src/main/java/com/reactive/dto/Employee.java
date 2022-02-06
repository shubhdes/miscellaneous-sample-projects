package com.reactive.dto;

public class Employee {

	private long id;

	private String name;

	private float rating;

	public Employee() {
		super();
	}

	public Employee(long id, String name, float rating) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", rating=" + rating + "]";
	}

}
