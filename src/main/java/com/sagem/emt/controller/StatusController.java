package com.sagem.emt.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sagem.emt.dao.entity.MovementDirection;
import com.sagem.emt.dao.entity.Status;
import com.sagem.emt.dao.repository.StatusRepository;

@RestController
@RequestMapping("status")
public class StatusController {
	@Autowired
	private StatusRepository statusRepository;

	@GetMapping
	public List<Status> findAll(@RequestParam(name = "direction", required = false) String direction) {
		return StringUtils.isEmpty(direction) ? statusRepository.findAll()
				: statusRepository.findByDirection(MovementDirection.valueOf(direction));
	}

	@PostMapping
	public Status save(@RequestBody Status reason) {
		return statusRepository.save(reason);
	}

	@DeleteMapping("clear")
	public void deleteAll() {
		statusRepository.deleteAll();
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id) {
		statusRepository.deleteById(id);
	}
}
