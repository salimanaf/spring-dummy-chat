package com.demo.chat.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Emotion")
public class EmotionEntity extends PayloadEntity {

	public EmotionEntity() {
		super();
	}


	public EmotionEntity(String payload) {
		super(payload);
	}

}
