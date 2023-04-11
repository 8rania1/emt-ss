package com.sagem.emt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagem.emt.dao.entity.Alert;
import com.sagem.emt.dao.repository.AlertRepository;

@Service
public class AlertService implements IAlertService {
	@Autowired
	private AlertRepository alertRepository;

	@Override
	public List<Alert> getAll() {
		// TODO Auto-generated method stub
		return alertRepository.findAll();
	}

	@Override
	public Alert addAlert(Alert a) {
		// TODO Auto-generated method stub
		return alertRepository.save(a);
	}

}
