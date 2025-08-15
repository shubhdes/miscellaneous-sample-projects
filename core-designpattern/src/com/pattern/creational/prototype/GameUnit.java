package com.pattern.creational.prototype;

import javafx.geometry.Point3D;

public abstract class GameUnit implements Cloneable {

	protected Point3D position;

	public GameUnit() {
		this.position = Point3D.ZERO;
	}

	@Override
	public GameUnit clone() throws CloneNotSupportedException {
		GameUnit gameUnit = (GameUnit) super.clone();
		gameUnit.initialize();
		return gameUnit;
	}

	public void initialize() {
		this.position = Point3D.ZERO;
	}

	public void move(int x, int y, int z) {
		this.position = new Point3D(x, y, z);
	}
}
