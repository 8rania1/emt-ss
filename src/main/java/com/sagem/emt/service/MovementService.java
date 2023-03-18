package com.sagem.emt.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.sagem.emt.dao.entity.Category;
import com.sagem.emt.dao.entity.Movement;
import com.sagem.emt.dao.entity.MovementDirection;
import com.sagem.emt.dao.repository.CategoryRepository;
import com.sagem.emt.dao.repository.EquipmentRepository;
import com.sagem.emt.dao.repository.MovementRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovementService {
    private final MovementRepository  movementRepository;
    private final EquipmentRepository equipmentRepository;
    private final CategoryRepository  categoryRepository;
    private final NotificationService notificationService;

    public Movement save(Movement movement) {
	equipmentRepository.available(movement.getDirection() == MovementDirection.IN,
		movement.getEquipment().getSerialNumber());
	if (movement.getDirection() == MovementDirection.OUT) {
	    threshold(movement.getEquipment().getCategory().getId());
	}
	return movementRepository.save(movement);
    }

    @Scheduled(fixedDelay = 10000000)
    public void threshold() {
	log.info("check threshold");
	this.categoryRepository.findAll().forEach(category -> threshold(category.getId()));
    }

    private void threshold(Long categoryId) {
	log.info("check category threshold {}", categoryId);
	Category category = this.categoryRepository.findById(categoryId).orElseThrow(RuntimeException::new);
	Long count = equipmentRepository.countByAvailableTrueAndCategory(category);
	if (count < category.getThreshold()) {
	    this.notificationService.notification("threshold reached", count + " available " + category.getName());
	}
    }
}
