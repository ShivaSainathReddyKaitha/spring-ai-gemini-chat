package com.project.LLM.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService{
	
	private ChatClient chatClient;
	
	public ChatServiceImpl(ChatClient.Builder builder) {
		this.chatClient = builder.build();
	}
	
	@Value("classpath:prompts/system_prompt.st")
	private Resource systemPrompt;
	
	@Value("classpath:prompts/user_prompt.st")
	private Resource userPrompt;
	
	@Override
	public String chatUsingGemini(String userFeedback) {
		return chatClient.prompt()
				  .system(systemPrompt)
				  .user(user -> user.text(userPrompt).param("userFeedback", userFeedback))
				  .call()
				  .content();
	}

}
