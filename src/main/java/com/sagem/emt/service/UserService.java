package com.sagem.emt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sagem.emt.dao.entity.User;
import com.sagem.emt.dao.repository.UserRepository;

@Service
public class UserService implements IUserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User addUser(User u) {
		// TODO Auto-generated method stub
		return userRepository.save(u);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		userRepository.deleteAll();
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}
}
