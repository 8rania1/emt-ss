package com.sagem.emt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sagem.emt.dao.entity.Categorie;
import com.sagem.emt.service.CategorieService;


@RestController
@RequestMapping("/categorie")
public class CategorieController {

	@Autowired
	private CategorieService categorieService;

	@GetMapping("/getAll")
	public List<Categorie> getAll() {
		return categorieService.getAll();
	}
	
	@PostMapping("/addCategorie")
	 public Categorie addUCategorieS(@RequestBody Categorie c) {
		 return categorieService.addCategorie(c);
	 }
	 
	@DeleteMapping("/deleteAll")
	 public void deleteAll() {
		categorieService.deleteAll();
	 }
	@DeleteMapping("/deleteCategorie/{id}")
	 public void deleteCategorie(@PathVariable("id")Long id) {
		categorieService.deleteCategorie(id);
	 }
}
