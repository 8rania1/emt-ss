package com.sagem.emt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagem.emt.dao.entity.Fournisseur;
import com.sagem.emt.service.FournisseurService;

@RestController
@RequestMapping("/fournisseur")
public class FournisseurController {
@Autowired 
private FournisseurService fournisseurService;
@GetMapping("/getAll")
public List<Fournisseur>getAll(){
	return fournisseurService.getAll();
}
@PostMapping("/addFournisseur")
public Fournisseur addFournisseur(Fournisseur f) {
	return fournisseurService.addFournisseur(f);
}
@DeleteMapping("/deleteAll")
public void deleteAll() {
	 fournisseurService.deleteAll();
}
@DeleteMapping("/deleteFournisseur/{id}")
public void deleteFournisseur(Long id) {
	 fournisseurService.deleteFournisseur(id);
}

}
