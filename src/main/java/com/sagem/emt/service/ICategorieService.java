package com.sagem.emt.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.sagem.emt.dao.entity.Categorie;

public interface ICategorieService {
	public List<Categorie> getAll();
	public Categorie addCategorie(@RequestBody Categorie c);
	public void deleteAll();
	public void deleteCategorie(@PathVariable("id")Long id) ;
}
