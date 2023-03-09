package com.sagem.emt.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.sagem.emt.dao.entity.Equipment;


public interface IEquipmentService {
	public List<Equipment> getAll();
	public Equipment addEquipment (@RequestBody Equipment e);
	public void deleteAll();
	public void deleteEquipment(@PathVariable("id")Long id );
}
