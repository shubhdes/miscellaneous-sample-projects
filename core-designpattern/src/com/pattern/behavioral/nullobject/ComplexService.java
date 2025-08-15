package com.pattern.behavioral.nullobject;

public class ComplexService {

	private StorageService storageService;

	public ComplexService(StorageService storageService) {
		this.storageService = storageService;
	}

	public void saveReport(Report report) {
		storageService.save(report);
	}
}
