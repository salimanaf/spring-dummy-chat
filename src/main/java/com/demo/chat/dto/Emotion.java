package com.demo.chat.dto;

public class Emotion extends Payload {

	public Emotion(String value) {
		super(value);
	}


	@Override
	public boolean validate() {
		return (getValue().length() > 1 && getValue().length() <= 10 && !getValue().matches(".*[0-9].*"));
	}
}
