package com.sagem.emt.dao.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagem.emt.dao.entity.Movement;
import com.sagem.emt.dao.entity.MovementDirection;
import com.sagem.emt.dao.entity.Reason;
import com.sagem.emt.dao.entity.User;

public interface MovementRepository extends JpaRepository<Movement, Long> {

	Long countByUserAndDirection(User user, MovementDirection direction);

	BigDecimal countByReason(Reason reason);

	List<Movement> findByEquipmentSerialNumber(String serialNumber);
}
