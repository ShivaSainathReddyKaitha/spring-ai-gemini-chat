package com.project.LLM.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService{
	
	private ChatClient chatClient;

	
	public ChatServiceImpl(ChatClient.Builder builder) {
		this.chatClient = builder.build();
	}

	@Override
	public String chatUsingGemini(String question) {
		return chatClient.prompt(question)
				  .call()
				  .content();
	}

}
