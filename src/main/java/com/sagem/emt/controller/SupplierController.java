package com.sagem.emt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagem.emt.dao.entity.Supplier;
import com.sagem.emt.dao.repository.SupplierRepository;

@RestController
@RequestMapping("supplier")
public class SupplierController {
	@Autowired
	private SupplierRepository supplierRepository;

	@GetMapping
	public List<Supplier> getAll() {
		return supplierRepository.findAll();
	}

	@PostMapping
	public Supplier save(@RequestBody Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	@DeleteMapping("clear")
	public void deleteAll() {
		supplierRepository.deleteAll();
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id) {
		supplierRepository.deleteById(id);
	}
}
