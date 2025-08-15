package com.pattern.creational.objectpool;

import com.sun.javafx.geom.Point2D;

public class BitmapImage implements Image {

	private Point2D location;

	private String name;

	public BitmapImage(String name) {
		this.name = name;
	}

	@Override
	public void draw() {
		System.out.println("Drawing image=" + name + " at location=" + location);
	}

	@Override
	public Point2D getLocation() {
		return location;
	}

	@Override
	public void setLocation(Point2D location) {
		this.location = location;
	}

	@Override
	public void reset() {
		this.location = null;
	}
}
