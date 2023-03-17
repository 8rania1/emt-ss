package com.sagem.emt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagem.emt.dao.entity.Equipment;
import com.sagem.emt.dao.repository.EquipmentRepository;

@Service
public class EquipmentService implements com.sagem.emt.service.EquipmentService {
    @Autowired
    private EquipmentRepository equipmentRepository;

    @Override
    public List<Equipment> getAll() {
	return equipmentRepository.findAll();
    }

    @Override
    public Equipment save(Equipment e) {
	return equipmentRepository.save(e);
    }

    @Override
    public void deleteAll() {
	equipmentRepository.deleteAll();
    }

    @Override
    public void delete(Long id) {
	equipmentRepository.deleteById(id);
    }

}
