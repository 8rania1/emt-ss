package com.sagem.emt.controller;

import java.util.List;

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
import com.sagem.emt.dao.entity.Reason;
import com.sagem.emt.dao.repository.ReasonRepository;

@RestController
@RequestMapping("reason")
public class ReasonController {
    @Autowired
    private ReasonRepository reasonRepository;

    @GetMapping
    public List<Reason> findAll(@RequestParam(name = "direction", required = true) String direction) {
	return reasonRepository.findByDirection(MovementDirection.valueOf(direction));
    }

    @PostMapping
    public Reason save(@RequestBody Reason reason) {
	return reasonRepository.save(reason);
    }

    @DeleteMapping("clear")
    public void deleteAll() {
	reasonRepository.deleteAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
	reasonRepository.deleteById(id);
    }
}
