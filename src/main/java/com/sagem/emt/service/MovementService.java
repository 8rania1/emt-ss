package com.sagem.emt.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sagem.emt.dao.entity.Category;
import com.sagem.emt.dao.entity.Movement;
import com.sagem.emt.dao.entity.MovementDirection;
import com.sagem.emt.dao.entity.User;
import com.sagem.emt.dao.repository.CategoryRepository;
import com.sagem.emt.dao.repository.EquipmentRepository;
import com.sagem.emt.dao.repository.MovementRepository;
import com.sagem.emt.dao.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovementService {
	private final MovementRepository movementRepository;
	private final EquipmentRepository equipmentRepository;
	private final CategoryRepository categoryRepository;
	private final UserRepository userRepository;

	private final NotificationService notificationService;
	private final EmailService emailService;

	@Transactional
	public Movement save(Movement movement) {

		equipmentRepository.available(movement.getDirection() == MovementDirection.IN,
				movement.getEquipment().getSerialNumber());
		if (movement.getDirection() == MovementDirection.OUT) {
			threshold(movement.getEquipment().getCategory().getId());
		}
		return movementRepository.save(movement);
	}

//    @Scheduled(fixedDelay = 1000)
	public void threshold() {
		log.info("check threshold");
		this.categoryRepository.findAll().forEach(category -> threshold(category.getId()));
	}

	private void threshold(Long categoryId) {
		log.info("check category threshold {}", categoryId);
		Category category = this.categoryRepository.findById(categoryId).orElseThrow(RuntimeException::new);
		Integer count = equipmentRepository.countByAvailableAndCategory(true, category);
		if (count < category.getThreshold()) {
			this.notificationService.alert(count + " available " + category.getName(), category);
			this.mail(category, count);
		}
	}

	private void mail(Category category, Integer available) {
		List<User> users = userRepository.findAll().stream()
				.filter(user -> user.getPermissions().contains("receive.mail.notification"))
				.collect(Collectors.toList());
		String message = "seuil atteinte , uniquememt " + available + " " + category.getName() + " en stock";
		users.forEach(user -> emailService.notification(user.getEmail(), "Seuil atteinte", message));

	}

}
