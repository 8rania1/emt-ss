package com.sagem.emt.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.sagem.emt.dao.entity.Alert;


public interface IAlertService {
 
	public List<Alert> getAll();
	public Alert addAlert(@RequestBody Alert a);
}
