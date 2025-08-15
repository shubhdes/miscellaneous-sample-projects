package com.pattern.structural.proxy;

import javafx.geometry.Point2D;

public class Client {

	public static void main(String[] args) {
		Image image = ImageFactory.getImage("javahub.bmp");
		image.setLocation(new Point2D(10, 10));
		image.render();
	}
}
