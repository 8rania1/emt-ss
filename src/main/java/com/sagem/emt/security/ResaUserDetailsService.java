package com.sagem.emt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sagem.emt.dao.repository.UserRepository;

@Service
public class ResaUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new ResaUserDetails(
				userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username)));
	}
}
