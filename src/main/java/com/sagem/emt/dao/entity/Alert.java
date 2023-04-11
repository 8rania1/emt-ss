package com.sagem.emt.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "alert")
public class Alert {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long idAlert;
	public String nom;
	public String description;

}
