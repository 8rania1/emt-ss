package com.sagem.emt.service;

import java.time.LocalDateTime;

import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import com.sagem.emt.dao.bo.Chat;
import com.sagem.emt.dao.entity.Alert;
import com.sagem.emt.dao.entity.Category;
import com.sagem.emt.dao.entity.Notification;
import com.sagem.emt.dao.repository.AlertRepository;
import com.sagem.emt.dao.repository.NotificationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationService {
	private final SimpMessageSendingOperations messagingTemplate;
	private final NotificationRepository notificationRepository;
	private final AlertRepository alertRepository;

	public void notification(String title, String message) {
		Notification notification = Notification.builder().title(title).message(message).build();
		notificationRepository.save(notification);
		messagingTemplate.convertAndSend("/topic/notification", notification);
	}

	public void alert(String message, Category category) {
		messagingTemplate.convertAndSend("/topic/notification", alertRepository
				.save(Alert.builder().message(message).category(category).date(LocalDateTime.now()).build()));
	}

	public Chat chat(Chat chat, Long recipient) {
		chat.setDate(LocalDateTime.now());
		messagingTemplate.convertAndSend("/topic/chat/" + recipient, chat);
		return chat;
	}
}
