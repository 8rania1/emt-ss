package com.sagem.emt.dao.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "movement")
@Data
public class Movement {
	@PrePersist
	public void prePersist() {
		this.date = LocalDateTime.now();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(updatable = false)
	private LocalDateTime date;
	@Column(nullable = false)
	private MovementDirection direction;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Equipment equipment;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Reason reason;
	private String note;
	@ManyToOne
	@JoinColumn(nullable = false)
	private User user;
}
