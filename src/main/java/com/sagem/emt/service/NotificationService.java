package com.sagem.emt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import com.sagem.emt.dao.entity.Notification;
import com.sagem.emt.dao.repository.NotificationRepository;

@Service
public class NotificationService {
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;
    @Autowired
    private NotificationRepository	 notificationRepository;

    public void notification(String title, String message) {
	Notification notification = Notification.builder().title(title).message(message).build();
	notificationRepository.save(notification);
	messagingTemplate.convertAndSend("/topic/progress", notification);
    }
}
