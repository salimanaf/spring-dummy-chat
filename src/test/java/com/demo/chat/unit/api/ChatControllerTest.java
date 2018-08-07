package com.demo.chat.unit.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.demo.chat.controller.ApiExceptionHandler;
import com.demo.chat.controller.ChatController;
import com.demo.chat.dto.Payload;
import com.demo.chat.entity.EmotionEntity;
import com.demo.chat.entity.TextEntity;
import com.demo.chat.exception.InvalidMessageInputException;
import com.demo.chat.service.ChatService;

@RunWith(SpringRunner.class)
public class ChatControllerTest {

	private MockMvc mockMvc;
	private @Mock ChatService chatService;
	private @InjectMocks ChatController chatController = new ChatController();


	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.chatController).setControllerAdvice(new ApiExceptionHandler()).build();
	}


	@Test
	public void testCreateValidChatText() throws Exception {
		String payload = "validmessage";

		TextEntity textMsg = new TextEntity(payload);

		Mockito.when(chatService.createRecord(Mockito.any(Payload.class))).thenReturn(textMsg);

		this.mockMvc.perform(post("/messages/send_text").param("payload", payload)).andExpect(status().isCreated());
	}


	@Test
	public void testCreateInvalidChatText() throws Exception {
		String payload = "";

		Mockito.when(chatService.createRecord(Mockito.any(Payload.class))).thenThrow(InvalidMessageInputException.class);

		this.mockMvc.perform(post("/messages/send_text").param("payload", payload)).andExpect(status().isPreconditionFailed());
	}


	@Test
	public void testCreateValidChatEmotion() throws Exception {
		String payload = "valid";

		EmotionEntity emotionMsg = new EmotionEntity(payload);

		Mockito.when(chatService.createRecord(Mockito.any(Payload.class))).thenReturn(emotionMsg);

		this.mockMvc.perform(post("/messages/send_emotion").param("payload", payload)).andExpect(status().isCreated());
	}


	@Test
	public void testCreateInvalidChatEmotion() throws Exception {
		String payload = "asdda12asda";

		Mockito.when(chatService.createRecord(Mockito.any(Payload.class))).thenThrow(InvalidMessageInputException.class);

		this.mockMvc.perform(post("/messages/send_emotion").param("payload", payload)).andExpect(status().isPreconditionFailed());
	}

}
