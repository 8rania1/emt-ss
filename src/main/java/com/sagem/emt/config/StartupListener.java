package com.sagem.emt.config;

import java.util.List;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.sagem.emt.dao.entity.User;
import com.sagem.emt.dao.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StartupListener implements ApplicationListener<ApplicationReadyEvent> {
	private final UserRepository userRepository;
	private final PasswordEncoder encoder;
	private final String email = "admin@sagemcom.com";

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		this.userRepository
				.save(this.userRepository.findByEmail(email).orElse(User.builder().email(email).firstName("admin")
						.lastName("admin").password(encoder.encode(email)).permissions(List.of("all")).build()));
	}
}
