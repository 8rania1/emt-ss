package com.sagem.emt.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagem.emt.dao.entity.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

}
