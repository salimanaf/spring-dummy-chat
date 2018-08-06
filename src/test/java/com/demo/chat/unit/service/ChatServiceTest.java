package com.demo.chat.unit.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.chat.dto.Emotion;
import com.demo.chat.dto.Text;
import com.demo.chat.entity.EmotionEntity;
import com.demo.chat.entity.TextEntity;
import com.demo.chat.exception.InvalidMessageInputException;
import com.demo.chat.repository.ChatRepository;
import com.demo.chat.service.ChatService;

@RunWith(SpringRunner.class)
public class ChatServiceTest {

	private @Mock ChatRepository chatRepository;
	private @InjectMocks ChatService chatService = new ChatService();


	@Test
	public void testCreateValidChatText() {
		String payload = "validmessage";

		TextEntity textMsg = new TextEntity(payload);

		Mockito.when(chatRepository.save(Mockito.any(TextEntity.class))).thenReturn(textMsg);

		TextEntity createdRecord = (TextEntity) chatService.createRecord(new Text(payload));

		Assert.assertEquals(textMsg, createdRecord);
	}


	@Test(expected = InvalidMessageInputException.class)
	public void testCreateInvalidChatText() {
		String payload = "";

		TextEntity textMsg = new TextEntity(payload);

		Mockito.when(chatRepository.save(Mockito.any(TextEntity.class))).thenReturn(textMsg);

		TextEntity createdRecord = (TextEntity) chatService.createRecord(new Text(payload));

		Assert.assertEquals(textMsg, createdRecord);
	}


	@Test
	public void testCreateValidChatEmotion() {
		String payload = "valid";

		EmotionEntity emotionMsg = new EmotionEntity(payload);

		Mockito.when(chatRepository.save(Mockito.any(EmotionEntity.class))).thenReturn(emotionMsg);

		EmotionEntity createdRecord = (EmotionEntity) chatService.createRecord(new Emotion(payload));

		Assert.assertEquals(emotionMsg, createdRecord);
	}


	@Test(expected = InvalidMessageInputException.class)
	public void testCreateInvalidChatEmotion() {
		String payload = "invalid12message";

		EmotionEntity emotionMsg = new EmotionEntity(payload);

		Mockito.when(chatRepository.save(Mockito.any(EmotionEntity.class))).thenReturn(emotionMsg);

		EmotionEntity createdRecord = (EmotionEntity) chatService.createRecord(new Emotion(payload));

		Assert.assertEquals(emotionMsg, createdRecord);
	}
}
