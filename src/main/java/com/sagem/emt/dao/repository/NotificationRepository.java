package com.sagem.emt.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sagem.emt.dao.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    
    @Transactional
    @Modifying
    @Query("update Notification notification set notification.read = true where notification.id = :id")
    void read(@Param("id") Long id);

}
