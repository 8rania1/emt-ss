package com.sagem.emt.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagem.emt.dao.entity.Permission;
import com.sagem.emt.dao.repository.PermissionRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("permission")
public class PermissionController {

	private final PermissionRepository permissionRepository;

	@GetMapping
	public List<Permission> permissions() {
		return permissionRepository.findAll();
	}
}
