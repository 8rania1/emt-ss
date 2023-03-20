package com.sagem.emt.service;

import org.springframework.web.bind.annotation.RequestBody;


import com.sagem.emt.dao.entity.Mouvement;

public interface IMouvementService {
	public Mouvement addMouvement (@RequestBody Mouvement e);
}
