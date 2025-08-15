package com.pattern.structural.composite;

public class Client {

	public static void main(String[] args) {
		File root = new Directory("javahub");
		File dir = new Directory("structural");
		dir.addFile(new BinaryFile("adpater", 0));
		dir.addFile(new BinaryFile("bridge", 0));
		dir.addFile(new BinaryFile("decorator", 0));
		dir.addFile(new BinaryFile("composite", 0));
		root.addFile(dir);
		root.ls();
	}
}
