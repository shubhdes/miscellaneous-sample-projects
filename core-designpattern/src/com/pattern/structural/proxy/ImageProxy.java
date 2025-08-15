package com.pattern.structural.proxy;

import javafx.geometry.Point2D;

public class ImageProxy implements Image {

	private String name;

	private Point2D location;

	private Image image;

	public ImageProxy(String name) {
		this.name = name;
	}

	@Override
	public void setLocation(Point2D location) {
		if (image != null) {
			image.setLocation(location);
		} else {
			this.location = location;
		}
	}

	@Override
	public Point2D getLocation() {
		if (image != null) {
			return image.getLocation();
		}
		return location;
	}

	@Override
	public void render() {
		if (image == null) {
			image = new BitmapImage(name);
			image.setLocation(location);
		}
		image.render();
	}
}
