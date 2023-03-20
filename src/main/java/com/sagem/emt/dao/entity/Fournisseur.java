package com.sagem.emt.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="fournisseur")

public class Fournisseur {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idF;
private String nom;
private String mail;
private String adresse;
private Integer numero;

}
