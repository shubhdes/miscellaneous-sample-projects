package com.pattern.creational.objectpool;

import com.sun.javafx.geom.Point2D;

public interface Image extends Poolable {

	void draw();

	Point2D getLocation();

	void setLocation(Point2D location);
}
