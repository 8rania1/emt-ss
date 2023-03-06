package com.sagem.emt.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.sagem.emt.dao.entity.tools;

public interface IToolService {
	public List<tools> getAll();
	public tools addTools (@RequestBody tools t);
	public void deleteAll();
	public void deletetool(@PathVariable("id")Long id );
}
