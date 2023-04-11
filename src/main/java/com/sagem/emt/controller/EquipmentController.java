package com.sagem.emt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagem.emt.dao.entity.Equipment;
import com.sagem.emt.service.EquipmentService;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {
	@Autowired
	private EquipmentService equipmentService;

	@GetMapping("/getAll")
	public List<Equipment> getAll() {
		return equipmentService.getAll();

	}

	@PostMapping("/addEquipment")
	public Equipment addEquipment(@RequestBody Equipment e) {
		return equipmentService.addEquipment(e);
	}

	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		equipmentService.deleteAll();
	}

	@DeleteMapping("/deleteEquipment{id}")
	public void deleteEquipment(@PathVariable("id") Long id) {
		equipmentService.deleteEquipment(id);
	}
}
