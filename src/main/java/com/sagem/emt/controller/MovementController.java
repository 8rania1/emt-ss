package com.sagem.emt.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sagem.emt.dao.entity.Movement;
import com.sagem.emt.dao.entity.MovementDirection;
import com.sagem.emt.dao.repository.MovementRepository;
import com.sagem.emt.security.ResaUserDetails;
import com.sagem.emt.service.MovementService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movement")
public class MovementController {

	private final MovementRepository movementRepository;
	private final MovementService movementService;

	@GetMapping
	@PostAuthorize("hasPermission('movement', 'collection.view')")
	public List<Movement> getAll(@RequestParam(name = "serialNumber",required = false) String serialNumber) {
		return StringUtils.isNotBlank(serialNumber)
				? movementRepository.findByEquipmentSerialNumber(serialNumber): movementRepository.findAll();
	}

	@GetMapping(path = "/direction")
	@PostAuthorize("hasPermission('movement', 'direction.view')")
	public List<String> direction() {
		return Arrays.asList(MovementDirection.values()).stream().map(MovementDirection::toString)
				.collect(Collectors.toList());
	}

	@PostMapping
	@PostAuthorize("hasPermission('movement', 'save')")
	public Movement save(@RequestBody Movement movement, Authentication authentication) {
		movement.setUser(ResaUserDetails.class.cast(authentication.getPrincipal()).getUser());
		return movementService.save(movement);
	}
}
