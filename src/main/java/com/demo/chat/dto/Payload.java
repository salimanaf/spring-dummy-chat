package com.demo.chat.dto;

public abstract class Payload {

	public Payload(String value) {
		super();
		this.value = value;
	}


	private String value;


	public abstract boolean validate();


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}

}
