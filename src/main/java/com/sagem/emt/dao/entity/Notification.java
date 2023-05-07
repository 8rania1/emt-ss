package com.sagem.emt.dao.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "notification")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @PrePersist
    public void prePersist() {
	this.time = LocalDateTime.now();
	this.read = false;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long	  id;
    private LocalDateTime time;
    private String	  title;
    private String	  message;
    @ManyToOne
    private User	  user;
    @Column(updatable = false)
    private boolean	  read;
}
