package com.sagem.emt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagem.emt.dao.entity.Alert;
import com.sagem.emt.dao.repository.AlertRepository;

@RestController
@RequestMapping("alert")
public class AlertController {
	@Autowired
	private AlertRepository alertRepository;

	@GetMapping
	public List<Alert> getAll() {
		return alertRepository.findAll();
	}

}
