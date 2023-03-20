package com.sagem.emt.dao.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="equipment")
public class Equipment {
	@Id
	private String numSerie;
	private String version;
	private String nom;
	private String pn;
	private String status;
	
	@ManyToOne
	private Categorie categorie;
   @OneToMany(mappedBy = "equipment",fetch = FetchType.LAZY)
   private List<Mouvement> mouvements;
   
}
