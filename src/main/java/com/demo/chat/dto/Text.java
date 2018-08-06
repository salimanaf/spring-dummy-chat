package com.demo.chat.dto;

public class Text extends Payload {

	public Text(String value) {
		super(value);
	}

	@Override
	public boolean validate() {
		return (getValue().length() > 0 && getValue().length() <= 160);
	}

}
