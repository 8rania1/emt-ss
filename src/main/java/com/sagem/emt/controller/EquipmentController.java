package com.sagem.emt.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagem.emt.dao.entity.Equipment;
import com.sagem.emt.dao.repository.EquipmentRepository;
import com.sagem.emt.dao.repository.MovementRepository;
import com.sagem.emt.service.NotificationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/equipment")
@RequiredArgsConstructor
public class EquipmentController {

	private final EquipmentRepository equipmentRepository;
	private final MovementRepository movementRepository;

	private final NotificationService notificationService;

	@GetMapping
	public Page<Equipment> getAll(Pageable pageable) {
		return equipmentRepository.findAll(pageable);
	}

	@GetMapping(path = "{id}")
	public Equipment equipment(@PathVariable(name = "id", required = true) Long id) {
		return equipmentRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	@PutMapping
	public Equipment edit(@RequestBody Equipment equipment) {
		equipment = equipmentRepository.save(equipment);
		notificationService.notification("equipement", "equipment " + equipment.getName() + " updated");
		return equipment;
	}

	@PostMapping
	public Equipment addEquipment(@RequestBody Equipment equipment) {
		equipment = equipmentRepository.save(equipment);
		notificationService.notification("equipement", "equipment " + equipment.getName() + " added");
		return equipment;
	}

	@DeleteMapping("clear")
	public void clear() {
		equipmentRepository.deleteAll();
	}

	@Transactional
	@DeleteMapping(path = "{id}")
	public void deleteEquipment(@PathVariable("id") Long id) {
		movementRepository.deleteByEquipmentId(id);
		equipmentRepository.deleteById(id);
	}
}
