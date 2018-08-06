package com.demo.chat.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Text")
public class TextEntity extends PayloadEntity {

	public TextEntity() {
		super();
	}


	public TextEntity(String payload) {
		super(payload);
	}

}
