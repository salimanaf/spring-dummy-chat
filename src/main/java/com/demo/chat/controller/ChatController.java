package com.demo.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.chat.dto.Payload;
import com.demo.chat.dto.PayloadFactory;
import com.demo.chat.service.ChatService;

@RestController
@RequestMapping("/messages")
public class ChatController {

	@Autowired
	private ChatService chatService;


	@RequestMapping(value = "{type}", method = RequestMethod.POST, consumes = "multipart/form-data")
	public ResponseEntity<?> processMessage(@PathVariable("type") String type, @RequestParam(name = "payload", required = true) String payload) {
		Payload payloadObj = new PayloadFactory().getPayload(type, payload);
		chatService.createRecord(payloadObj);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
