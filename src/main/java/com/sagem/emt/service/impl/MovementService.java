package com.sagem.emt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagem.emt.dao.entity.Movement;
import com.sagem.emt.dao.repository.MovementRepository;

@Service
public class MovementService implements com.sagem.emt.service.MovementService {
    @Autowired
    private MovementRepository mouvementRepository;

    @Override
    public Movement save(Movement movement) {
	return mouvementRepository.save(movement);
    }

}
