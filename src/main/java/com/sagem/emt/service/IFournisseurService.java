package com.sagem.emt.service;

import java.util.List;

import com.sagem.emt.dao.entity.Fournisseur;

public interface IFournisseurService {
 
	public List<Fournisseur>getAll();
	   public Fournisseur addFournisseur(Fournisseur f);
	   public void deleteAll();
	   public void deleteFournisseur(Long id);
}
