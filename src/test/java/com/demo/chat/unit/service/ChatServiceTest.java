package com.demo.chat.unit.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.chat.repository.ChatRepository;
import com.demo.chat.service.ChatService;

@RunWith(SpringRunner.class)
public class ChatServiceTest {

	private @Mock ChatRepository chatRepository;
	private @InjectMocks ChatService chatService = new ChatService();


	@Test
	public void testCreateChatData() {
		/*String payload = "asdasdasdasda";

		ChatData chatData = new ChatData(payload, Text.class.getSimpleName());

		Mockito.when(chatRepository.save(Mockito.any(ChatData.class)).thenReturn(chatData);

		ChatData createdRecord = chatService.createRecord(new Text(payload));

		Assert.assertEquals(chatData, createdRecord);*/
	}

}
