package com.sagem.emt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagem.emt.dao.entity.Mouvement;
import com.sagem.emt.service.MouvementService;

@RestController
@RequestMapping("/mouvement")
public class MouvementController {
@Autowired
private MouvementService mouvementService;
	@PostMapping("/addMouvement")
	public Mouvement addMouvement (@RequestBody Mouvement e) {
		return mouvementService.addMouvement(e);
	}
}
