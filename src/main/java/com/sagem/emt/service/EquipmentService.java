package com.sagem.emt.service;

import java.util.List;

import com.sagem.emt.dao.entity.Equipment;

public interface EquipmentService {
    public List<Equipment> getAll();

    public Equipment save(Equipment equipment);

    public void deleteAll();

    public void delete(Long id);
}
