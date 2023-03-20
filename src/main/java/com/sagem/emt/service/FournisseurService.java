package com.sagem.emt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagem.emt.dao.entity.Fournisseur;
import com.sagem.emt.dao.repository.FournisseurRepository;

@Service
public class FournisseurService implements IFournisseurService{
 @Autowired
 private FournisseurRepository fournisseurRepository;

@Override
public List<Fournisseur> getAll() {
	// TODO Auto-generated method stub
	return fournisseurRepository.findAll();
}

@Override
public Fournisseur addFournisseur(Fournisseur f) {
	// TODO Auto-generated method stub
	return fournisseurRepository.save(f);
}

@Override
public void deleteAll() {
	// TODO Auto-generated method stub
	fournisseurRepository.deleteAll();
}

@Override
public void deleteFournisseur(Long id) {
	// TODO Auto-generated method stub
	fournisseurRepository.deleteById(id);
}


 
}
