package com.sagem.emt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagem.emt.dao.entity.tools;
import com.sagem.emt.dao.repository.ToolsRepository;
@Service
public class ToolService implements IToolService {
 @Autowired
 private ToolsRepository toolsRepository;

	
 @Override
	public List<tools> getAll() {
		// TODO Auto-generated method stub
		return toolsRepository.findAll();
	}
 
	@Override
	public tools addTools(tools t) {
		// TODO Auto-generated method stub
		return toolsRepository.save(t);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		toolsRepository.deleteAll();
	}

	@Override
	public void deletetool(Long id) {
		// TODO Auto-generated method stub
		toolsRepository.deleteById(id);
	}


	

}
