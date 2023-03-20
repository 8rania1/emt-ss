package com.sagem.emt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagem.emt.dao.entity.Alert;
import com.sagem.emt.service.AlertService;

@RestController
@RequestMapping("/alert")
public class AlertController {
@Autowired 
private AlertService alertService;
@GetMapping("/getAll")
public List<Alert> getAll(){
	return alertService.getAll();
	
}
@PostMapping("/addAlert")
public Alert addAlert(@RequestBody Alert a) {
	return alertService.addAlert(a);
}
}
