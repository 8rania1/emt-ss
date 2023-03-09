package com.sagem.emt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagem.emt.dao.entity.Mouvement;
import com.sagem.emt.dao.repository.MouvementRepository;
@Service
public class MouvementService implements IMouvementService {
@Autowired
private MouvementRepository mouvementRepository;
	@Override
	public Mouvement addMouvement(Mouvement e) {
		// TODO Auto-generated method stub
		return mouvementRepository.save(e);
	}

}
