package com.sagem.emt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagem.emt.dao.entity.Movement;
import com.sagem.emt.service.MovementService;

@RestController
@RequestMapping("/movement")
public class MovementController {
    @Autowired
    private MovementService mouvementService;

    @PostMapping
    public Movement save(@RequestBody Movement movement) {
	return mouvementService.save(movement);
    }
}
