package com.sagem.emt.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.sagem.emt.security.ResaUserDetails;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
	private final UserRepository userRepository;
	private final MovementRepository movementRepository;
	private final PasswordEncoder encoder;

	@GetMapping
	public List<User> findAll(@RequestParam(name = "count", required = false) boolean count,
			Authentication authentication) {
		User user = ResaUserDetails.class.cast(authentication.getPrincipal()).getUser();
		return userRepository.findAll().stream().filter(item -> !Objects.equals(item.getId(), user.getId()))
				.collect(Collectors.toList());
	}

	@PostMapping
	public User save(@RequestBody User user) {
		user.setPassword(encoder.encode(user.getEmail()));
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
