package com.sagem.emt.dao.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="mouvement")
@Data
public class Mouvement {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private Date date;
private TypeMvm type;
@ManyToOne
private Equipment equipment;
}
