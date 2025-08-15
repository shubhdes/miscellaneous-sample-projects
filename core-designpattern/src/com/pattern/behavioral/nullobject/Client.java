package com.pattern.behavioral.nullobject;

public class Client {

	public static void main(String[] args) {

		Report report = new Report("durga.txt", "Welcome to durgasoftware solutions");

		StorageService storageService = new NullStorageService();
		ComplexService complexService = new ComplexService(storageService);
		complexService.saveReport(report);
	}
}
