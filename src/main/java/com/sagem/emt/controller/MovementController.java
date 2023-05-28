package com.sagem.emt.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.sagem.emt.service.VoucherService;

import lombok.RequiredArgsConstructor;
import net.kaczmarzyk.spring.data.jpa.domain.Between;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import net.sf.jasperreports.engine.JRException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movement")
public class MovementController {

	private final MovementRepository movementRepository;
	private final MovementService movementService;
	private final VoucherService voucherService;

	@GetMapping
	public List<Movement> getAll(@RequestParam(name = "serialNumber", required = false) String serialNumber) {
		return StringUtils.isNotBlank(serialNumber) ? movementRepository.findByEquipmentSerialNumber(serialNumber)
				: movementRepository.findAll();
	}

	@GetMapping(path = "search")
	public List<Movement> search(@And({
			@Spec(path = "equipment.serialNumber", params = "serialNumber", spec = Equal.class),
			@Spec(path = "date", params = { "startDate",
					"endDate" }, spec = Between.class, config = "yyyy-MM-dd'T'HH:mm:ss") }) Specification<Movement> criteria) {
		return movementRepository.findAll(criteria);
	}

	@GetMapping(path = "download")
	public ResponseEntity<InputStreamResource> download(@And({
			@Spec(path = "equipment.serialNumber", params = "serialNumber", spec = Equal.class),
			@Spec(path = "date", params = { "startDate",
					"endDate" }, spec = Between.class, config = "yyyy-MM-dd'T'HH:mm:ss") }) Specification<Movement> criteria)
			throws IOException, JRException {
		List<com.sagem.emt.dao.bo.Movement> movements = this.movementRepository.findAll(criteria).stream()
				.map(item -> com.sagem.emt.dao.bo.Movement.builder().date(item.getDate())
						.direction(item.getDirection().name()).equipment(item.getEquipment().getName())
						.reason(item.getStatus().getTitle()).build())
				.collect(Collectors.toList());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"test\"")
				.body(new InputStreamResource(this.voucherService.generate(movements)));
	}

	@GetMapping(path = "/direction")
	public List<String> direction() {
		return Arrays.asList(MovementDirection.values()).stream().map(MovementDirection::toString)
				.collect(Collectors.toList());
	}

	@PostMapping
	public Movement save(@RequestBody Movement movement, Authentication authentication) {
		movement.setUser(ResaUserDetails.class.cast(authentication.getPrincipal()).getUser());
		return movementService.save(movement);
	}
}
