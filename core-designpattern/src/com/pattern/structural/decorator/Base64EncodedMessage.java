package com.pattern.structural.decorator;

import java.util.Base64;

public class Base64EncodedMessage implements Message {

	private Message message;

	public Base64EncodedMessage(Message message) {
		this.message = message;
	}

	@Override
	public String getContent() {
		byte[] content = message.getContent().getBytes();
		return Base64.getEncoder().encodeToString(content);
	}
}
