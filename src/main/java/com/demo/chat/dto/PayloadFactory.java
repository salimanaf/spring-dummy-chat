package com.demo.chat.dto;

public class PayloadFactory {

	public Payload getPayload(String type, String payload) {
		if ("send_text".equals(type)) {
			return new Text(payload);
		} else if ("send_emotion".equals(type)) {
			return new Emotion(payload);
		} else {
			throw new UnsupportedOperationException();
		}
	}
}
