package com.sagem.emt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sagem.emt.dao.bo.Chat;
import com.sagem.emt.service.NotificationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {
	private final NotificationService notificationService;

	@PostMapping
	public ResponseEntity<Chat> send(@RequestBody Chat chat, @RequestParam(name = "recipient") Long recipient) {
		return ResponseEntity.ok(this.notificationService.chat(chat, recipient));
	}

}
