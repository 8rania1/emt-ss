package com.sagem.emt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagem.emt.dao.entity.Categorie;
import com.sagem.emt.dao.repository.CategorieRepository;

@Service
public class CategorieService implements ICategorieService {
@Autowired
private CategorieRepository categorieRepository;

@Override
public List<Categorie> getAll() {
	// TODO Auto-generated method stub
	return categorieRepository.findAll();
}

@Override
public Categorie addCategorie(Categorie c) {
	// TODO Auto-generated method stub
	return categorieRepository.save(c);
}

@Override
public void deleteAll() {
	// TODO Auto-generated method stub
	categorieRepository.deleteAll();
}

@Override
public void deleteCategorie(Long id) {
	// TODO Auto-generated method stub
	categorieRepository.deleteById(id);
}

}
