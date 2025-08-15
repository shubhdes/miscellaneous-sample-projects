package com.pattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory extends File {

	private List<File> children = new ArrayList<>();

	public Directory(String name) {
		super(name);
	}

	@Override
	public void ls() {
		System.out.println("Name=" + getName() + " Size=" + children.size());
		for (File child : children) {
			child.ls();
		}
	}

	@Override
	public void addFile(File file) {
		children.add(file);
	}

	@Override
	public File[] getFiles() {
		return children.toArray(new File[children.size()]);
	}

	@Override
	public boolean removeFile(File file) {
		return children.remove(file);
	}

}
