package com.sagem.emt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagem.emt.dao.entity.Movement;
import com.sagem.emt.dao.repository.MovementRepository;
import com.sagem.emt.service.MovementService;

@RestController
@RequestMapping("/movement")
public class MovementController {
    @Autowired
    private MovementRepository movementRepository;
    @Autowired
    private MovementService    movementService;

    @GetMapping
    public Page<Movement> getAll(Pageable pageable) {
	return movementRepository.findAll(pageable);
    }

    @PostMapping
    public Movement save(@RequestBody Movement movement) {
	return movementService.save(movement);
    }
}
