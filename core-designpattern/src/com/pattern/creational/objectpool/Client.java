package com.pattern.creational.objectpool;

import java.util.function.Supplier;

import com.sun.javafx.geom.Point2D;

public class Client {

	public static void main(String[] args) throws InterruptedException {
		Supplier<BitmapImage> creator = () -> new BitmapImage("javahublogo.bmp");
		ObjectPool<BitmapImage> pool = new ObjectPool<BitmapImage>(creator, 5);
		BitmapImage image = pool.get();
		image.setLocation(new Point2D(10, 10));
		image.draw();
		pool.release(image);
	}
}
