package com.sagem.emt.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sagem.emt.dao.bo.MovementDirectionCount;
import com.sagem.emt.dao.entity.MovementDirection;
import com.sagem.emt.dao.entity.User;
import com.sagem.emt.dao.repository.MovementRepository;
import com.sagem.emt.dao.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
	private final UserRepository userRepository;
	private final MovementRepository movementRepository;

	@GetMapping
	public List<User> findAll(@RequestParam(name = "count", required = false) boolean count) {
		List<User> users = userRepository.findAll();
		if (count) {
			users.forEach(user -> user.setCounts(this.movememts(user)));
		}
		return users;
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

	private List<MovementDirectionCount> movememts(User user) {
		return Arrays.asList(MovementDirection.values()).stream()
				.map(direction -> MovementDirectionCount.builder().direction(direction)
						.count(movementRepository.countByUserAndDirection(user, direction)).build())
				.collect(Collectors.toList());

	}
}
