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

@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentRepository equipmentRepository;

    @GetMapping
    public Page<Equipment> getAll(Pageable pageable) {
	return equipmentRepository.findAll(pageable);
    }

    @PostMapping
    public Equipment addEquipment(@RequestBody Equipment equipment) {
	return equipmentRepository.save(equipment);
    }

    @DeleteMapping("clear")
    public void clear() {
	equipmentRepository.deleteAll();
    }

    @DeleteMapping("{id}")
    public void deleteEquipment(@PathVariable("id") Long id) {
	equipmentRepository.deleteById(id);
    }
}
