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

import com.sagem.emt.dao.entity.User;
import com.sagem.emt.dao.repository.UserRepository;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> findAll() {
	return userRepository.findAll();
    }

    @PostMapping
    public User save(@RequestBody User user) {
	return userRepository.save(user);
    }

    @DeleteMapping("/clear")
    public void deleteAll() {
	userRepository.deleteAll();
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") Long id) {
	userRepository.deleteById(id);
    }
}
