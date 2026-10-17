package com.project.LLM.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.LLM.service.ChatService;

@RestController
@RequestMapping("/chat")
public class ChatController {
	
	private final ChatService service;

	public ChatController(ChatService service) {
		this.service = service;
	}
	
	@GetMapping("/gemini")
	public ResponseEntity<?> callChat(@RequestParam("message") String message) {
		return ResponseEntity.ok(service.chatUsingGemini(message));
	}
	
	
}
