package com.sagem.emt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagem.emt.dao.entity.Equipment;
import com.sagem.emt.dao.repository.EquipmentRepository;
import com.sagem.emt.service.NotificationService;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {
	@Autowired

	private EquipmentRepository equipmentRepository;
	@Autowired
	private NotificationService notificationService;

	@GetMapping
	public Page<Equipment> getAll(Pageable pageable) {
		return equipmentRepository.findAll(pageable);
	}

	@GetMapping(path = "{serialNumber}")
	public Equipment equipment(@PathVariable(name = "serialNumber", required = true) String serialNumber) {
		return equipmentRepository.findById(serialNumber).orElseThrow(RuntimeException::new);
	}

	@PostMapping
	public Equipment addEquipment(@RequestBody Equipment equipment) {
		equipment = equipmentRepository.save(equipment);
		notificationService.notification("equipement", "new equipment " + equipment.getName() + " added");
		return equipment;
	}

	@DeleteMapping("clear")
	public void clear() {
		equipmentRepository.deleteAll();
	}

	@DeleteMapping("{id}")
	public void deleteEquipment(@PathVariable("serialNumber") String serialNumber) {
		equipmentRepository.deleteById(serialNumber);
	}
}
