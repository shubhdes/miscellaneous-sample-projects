package com.pattern.behavioral.nullobject;

import java.io.PrintWriter;

public class StorageService {

	public void save(Report report) {

		try (PrintWriter writer = new PrintWriter(report.getName())) {

			writer.println(report.getContents());
		} catch (Exception ex) {
			System.out.println("Failed to write report");
		}
	}
}
