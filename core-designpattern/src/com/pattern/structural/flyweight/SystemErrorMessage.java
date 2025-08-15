package com.pattern.structural.flyweight;

public class SystemErrorMessage implements ErrorMessage {

	private String messageTemplate;

	private String helpBaseUrl;

	public SystemErrorMessage(String messageTemplate, String helpBaseUrl) {
		this.messageTemplate = messageTemplate;
		this.helpBaseUrl = helpBaseUrl;
	}

	@Override
	public String getText(String errorCode) {
		return messageTemplate.replace("$errorCode", errorCode) + helpBaseUrl + errorCode;
	}
}
