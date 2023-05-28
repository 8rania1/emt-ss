package com.sagem.emt.dao.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sagem.emt.dao.entity.Movement;
import com.sagem.emt.dao.entity.MovementDirection;
import com.sagem.emt.dao.entity.Status;
import com.sagem.emt.dao.entity.User;

public interface MovementRepository extends JpaRepository<Movement, Long>, JpaSpecificationExecutor<Movement> {

	Long countByUserAndDirection(User user, MovementDirection direction);

	BigDecimal countByStatus(Status reason);

	void deleteByEquipmentId(Long id);

	List<Movement> findByEquipmentSerialNumber(String serialNumber);
}
