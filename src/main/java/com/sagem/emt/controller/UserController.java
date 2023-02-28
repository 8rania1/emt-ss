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
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/getAll")
	public List<User> getAll() {
		return userService.getAll();
	}
	
	@PostMapping("/addUser")
	 public User addUser(@RequestBody User u) {
		 return userService.addUser(u);
	 }
	 
	@DeleteMapping("/deleteAll")
	 public void deleteAll() {
		 userService.deleteAll();
	 }
	@DeleteMapping("/deleteUser/{id}")
	 public void deleteUser(@PathVariable("id")Long id) {
		 userService.deleteUser(id);
	 }
	 
}
