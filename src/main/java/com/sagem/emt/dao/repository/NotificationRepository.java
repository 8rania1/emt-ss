package com.sagem.emt.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagem.emt.dao.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
