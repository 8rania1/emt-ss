package com.sagem.emt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagem.emt.dao.entity.Notification;
import com.sagem.emt.dao.repository.NotificationRepository;

@RestController
@RequestMapping("notification")
public class NotificationController {
    @Autowired
    private NotificationRepository notificationRepository;

    @GetMapping
    public List<Notification> findAll() {
	return this.notificationRepository.findAll();
    }

    @PutMapping
    
    public void read(@RequestBody Notification notification) {
	this.notificationRepository.read(notification.getId());
    }
}
