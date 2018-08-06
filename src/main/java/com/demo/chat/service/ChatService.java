package com.demo.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.chat.dto.Payload;
import com.demo.chat.dto.Text;
import com.demo.chat.entity.EmotionEntity;
import com.demo.chat.entity.PayloadEntity;
import com.demo.chat.entity.TextEntity;
import com.demo.chat.exception.InvalidMessageInputException;
import com.demo.chat.repository.ChatRepository;

@Service
@Transactional
public class ChatService {

	@Autowired
	private ChatRepository chatRepository;


	@Transactional
	public PayloadEntity createRecord(Payload payload) throws InvalidMessageInputException {

		if (!payload.validate()) {
			throw new InvalidMessageInputException("Invalid message input");
		}

		PayloadEntity pe;
		if (payload instanceof Text) {
			pe = new TextEntity(payload.getValue());
		} else {
			pe = new EmotionEntity(payload.getValue());
		}

		return chatRepository.save(pe);
	}

}
