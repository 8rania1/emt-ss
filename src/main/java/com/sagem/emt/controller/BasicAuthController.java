package com.sagem.emt.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagem.emt.dao.entity.User;
import com.sagem.emt.security.ResaUserDetails;

@RestController
public class BasicAuthController {
	@GetMapping(path = "/whoami")
	public User basicauth(Authentication authentication) {
		return ResaUserDetails.class.cast(authentication.getPrincipal()).getUser();
	}
}
