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
import com.sagem.emt.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll() {
	return userService.getAll();
    }

    @PostMapping
    public User save(@RequestBody User user) {
	return userService.save(user);
    }

    @DeleteMapping("/clear")
    public void deleteAll() {
	userService.deleteAll();
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") Long id) {
	userService.delete(id);
    }
}
