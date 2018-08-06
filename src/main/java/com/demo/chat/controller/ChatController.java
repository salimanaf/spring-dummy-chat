package com.demo.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.chat.dto.Emotion;
import com.demo.chat.dto.Payload;
import com.demo.chat.dto.Text;
import com.demo.chat.service.ChatService;

@RestController
@RequestMapping("/messages")
public class ChatController {

	@Autowired
	private ChatService chatService;


	@RequestMapping(value = "/send_text", method = RequestMethod.POST)
	public ResponseEntity<?> sendMessage(@RequestParam(name = "payload", required = true) String payload) {
		return execute(new Text(payload));

	}


	@RequestMapping(value = "/send_emotion", method = RequestMethod.POST)
	public ResponseEntity<?> sendEmotion(@RequestParam(name = "payload", required = true) String payload) {
		return execute(new Emotion(payload));
	}


	private ResponseEntity<?> execute(Payload payload) {
		chatService.createRecord(payload);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
