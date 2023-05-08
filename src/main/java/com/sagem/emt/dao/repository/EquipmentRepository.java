package com.sagem.emt.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sagem.emt.dao.entity.Category;
import com.sagem.emt.dao.entity.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
	@Modifying
	@Query("update Equipment equipment set equipment.available = :available where equipment.serialNumber = :serialNumber")
	void available(@Param("available") boolean available, @Param("serialNumber") String serialNumber);

	Long countByAvailableAndCategory(boolean available, Category category);

}
