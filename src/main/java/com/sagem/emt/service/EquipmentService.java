package com.sagem.emt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagem.emt.dao.entity.Equipment;
import com.sagem.emt.dao.repository.EquipmentRepository;

@Service
public class EquipmentService implements IEquipmentService {
	@Autowired
	private EquipmentRepository equipmentRepository;

	@Override
	public List<Equipment> getAll() {
		// TODO Auto-generated method stub
		return equipmentRepository.findAll();
	}

	@Override
	public Equipment addEquipment(Equipment e) {
		// TODO Auto-generated method stub
		return equipmentRepository.save(e);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		equipmentRepository.deleteAll();
	}

	@Override
	public void deleteEquipment(Long id) {
		// TODO Auto-generated method stub
		equipmentRepository.deleteById(id);
	}

}
